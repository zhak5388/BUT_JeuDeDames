import java.util.ArrayList;

public class PriseMajoritaireMethodes {
    /**
     * Renvoie l'ensemble des chemins distincts de la prise la plus longue pour une pièce donnée du damier sous forme d'ArrayList de dimension 2.
     * Un chemin est définie comme étant un ensemble de positions, en notation "indice de tableau", dont le premier élement correspond à la position de départ de la pièce donnée
     * suivie de la position de la pièce prise, suivie de la position d'arrivée de la pièce, suivie de l'éventuelle position de la seconde  pièce prise, suivie de l'enventuelle nouvelle position d'arrivée de la pièce, etc..
     * Cet enchainement continu jusqu'à qu'il n'y ait plus de prise possible.
     * Le chemin a pour dernier élément sa position finale d'arrivée.
     * Rappel: Un "indice de tableau" est un nombre à 2 chiffres dont le chiffre de gauche correspond à l'indice de la ligne du damier et celui de droite à l'indice de la colonne
     * Étant donnée que les chemins correspondent à la prise la plus longue, ils ont tous le même nombre d'élement.
     * Deux chemins dont un élément différe sont considérés comme distincts même si elles ont la "même forme" sur le damier.
     * Le résultat est donné sous forme de tableau extensible (ArrayList) de dimension 2.
     * La première dimension de l'ArrayList correspond au "chemin" et la deuxième dimension les différentes positions.
     * Renvoie un ArrauList de taille nulle si la pièce contenue à la position caseDepart ne peut pas faire de prise ou bien que caseDepart ne contient pas de pièces.
     * @param plateau tableau du damier : tableau de dimension 2 dont chaque dimension est de taille 10 respectant les conventions définies.
     * @param caseDepart indice en notation "d'indice de tableau" de la pièce dont on cherche à connaitre l'ensemble de ses chemin(s) de prise majoritaire
     * @return ArrayList de dimension 2 correspondant à l'ensemble des chemins de prise les plus longs pour une pièce donnée
     */
    public static ArrayList<ArrayList<Integer>> cheminsPriseMajoritaire(int[][] plateau, int caseDepart){
        ArrayList<ArrayList<Integer>> cheminPriseMajoritaire = cheminsDesPrises(plateau, caseDepart);
        if(cheminPriseMajoritaire.size() > 1){
            for(int i = (cheminPriseMajoritaire.size() - 1); i > 0; i--){
                if(cheminPriseMajoritaire.get(i).size() > cheminPriseMajoritaire.get(i-1).size()){
                    cheminPriseMajoritaire.remove(i-1);
                }
                else if(cheminPriseMajoritaire.get(i).size() < cheminPriseMajoritaire.get(i-1).size())
                {
                    cheminPriseMajoritaire.remove(i);
                }
            }}
        return cheminPriseMajoritaire;
    }

    /**
     * Renvoie l'ensemble des chemins distincts de(s) prise(s) successive(s) possible(s) pour une pièce donnée du damier sous forme d'ArrayList de dimension 2.
     * Un chemin est définie comme étant un ensemble de positions, en notation "indice de tableau", dont le premier élement correspond à la position de départ de la pièce donnée
     * suivie de la position de la pièce prise, suivie de la position d'arrivée de la pièce, suivie de l'éventuelle position de la seconde  pièce prise, suivie de l'enventuelle nouvelle position d'arrivée de la pièce, etc..
     * Cet enchainement continu jusqu'à qu'il n'y air plus de prise possible.
     * Le chemin a pour dernier élément sa position finale d'arrivée.
     * Deux chemins dont un élément différe sont considérés comme distincts même si elles ont la "même forme" sur le damier.
     * Le résultat est donné sous forme de tableau extensible (ArrayList) de dimension 2.
     * La première dimension de l'ArrayList correspond au "chemin" et la deuxième dimension les différentes positions.
     * Renvoie un ArrauList de taille nulle si la pièce contenue à la position caseDepart ne peut pas faire de prise ou bien que caseDepart ne contient pas de pièces.
     * @param plateau tableau du damier : tableau de dimension 2 dont chaque dimension est de taille 10 respectant les conventions définies.
     * @param caseDepart indice en notation "d'indice de tableau" de la pièce dont on cherche à connaitre l'ensemble de ses chemin(s) de prise(s) possible(s)
     * @return ArrayList de dimension 2 contenant l'ensemble des chemins possibles
     */
    public static ArrayList<ArrayList<Integer>> cheminsDesPrises(int[][] plateau, int caseDepart){
        ArrayList<ArrayList<Integer>> cheminsDesPrises = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> arbreDesPrises = new ArrayList<ArrayList<Integer>>();

        ArrayList<ArrayList<Integer>> prisePossible = prisePossible(plateau, caseDepart);
        if(prisePossible.size() != 0){

            /*Initialisation de l'arbre*/
            ajoutArbreDesPrises(arbreDesPrises,caseDepart,0,-1);
            for(int indiceListePrise = 0 ; indiceListePrise < prisePossible.size(); indiceListePrise++){
                int numeroCaseArrivee = prisePossible.get(indiceListePrise).get(1);
                int indiceParent = 0;
                int numeroCasePrise = prisePossible.get(indiceListePrise).get(0);
                ajoutArbreDesPrises(arbreDesPrises,numeroCaseArrivee,indiceParent,numeroCasePrise);
            }

            boolean arbreImcomplet = true;
            int indiceArbre = 1;

            int valeurPieceJouee = plateau[caseDepart/10][caseDepart%10]; //Doit être stocké, car une piece peut repasser la case de depart

            while(arbreImcomplet){
                marquePriseSurPlateau(plateau,listeDesPrisesCumulees(arbreDesPrises,indiceArbre));

                int caseActuelle = arbreDesPrises.get(indiceArbre).get(0);

                plateau[caseActuelle/10][caseActuelle%10] = valeurPieceJouee;
                plateau[caseDepart/10][caseDepart%10] = VariablesGlobales.codeCaseVide;

                ArrayList<ArrayList<Integer>> prisePossiblePourCaseActuelle = prisePossible(plateau, caseActuelle);
                if(prisePossiblePourCaseActuelle.size() != 0){
                    for(int i = 0; i < prisePossiblePourCaseActuelle.size(); i++){
                        int numeroCaseArrivee = prisePossiblePourCaseActuelle.get(i).get(1);
                        int indiceParent = indiceArbre;
                        int numeroCasePrise = prisePossiblePourCaseActuelle.get(i).get(0);
                        ajoutArbreDesPrises(arbreDesPrises,numeroCaseArrivee,indiceParent,numeroCasePrise);
                    }
                }
                else{
                    int indice = indiceArbre;
                    ArrayList<Integer> cheminPrise = new ArrayList<Integer>();
                    cheminPrise.add(caseDepart);
                    while (indice > 0){
                        cheminPrise.add(1,arbreDesPrises.get(indice).get(0)); //Case "arrivee";
                        cheminPrise.add(1,arbreDesPrises.get(indice).get(2));
                        indice = arbreDesPrises.get(indice).get(1); //IndiceParent
                    }
                    cheminsDesPrises.add(cheminPrise);
                }

                plateau[caseActuelle/10][caseActuelle%10] = VariablesGlobales.codeCaseVide;
                plateau[caseDepart/10][caseDepart%10] = valeurPieceJouee;

                enleveMarquePriseSurPlateau(plateau,listeDesPrisesCumulees(arbreDesPrises,indiceArbre));
                indiceArbre++;
                if(indiceArbre >= arbreDesPrises.size()){
                    arbreImcomplet = false;
                }

            }
        }

        //return arbreDesPrises;
        return cheminsDesPrises;
    }

    /**
     * Renvoie l'ensemble des couples possibles (position de départ, position d'arrivée) pour un mouvement de prise simple d'une pièce donnée du damier.
     * Les positions sont données en notation dite "d'indice de tableau" telle que définie en début de document.
     * Rappel: Un "indice de tableau" est un nombre à 2 chiffres dont le chiffre de gauche correspond à l'indice de la ligne du damier et celui de droite à l'indice de la colonne
     * Le résultat est donné sous forme de tableau extensible (ArrayList) de dimension 2.
     * La première dimension correspond à au couple.
     * Ce couple est un ArrayList de taille 2, avec comme premier élément la position de départ de la pièce et deuxième élément sa posistion d'arrivée.
     * L'ArrayList renvoyé est taille nulle dans le cas où aucun mouvement de prise est possible ou bien que la valeur de la case à vérifier n'est pas une pièce.
     * @param plateau tableau du damier : tableau de dimension 2 dont chaque dimension est de taille 10 respectant les conventions définies.
     * @param caseAVerifier indice en notation "d'indice de tableau" de la pièce dont l'on souhaite connaitre l'ensemble des prises possibles
     * @return ArrayList de dimension 2 correspondant à l'ensemble des couples possibles (position de départ, position d'arrivée) pour un mouvement de prise simple de la pièce en position caseAVerifier .
     */
    public static ArrayList<ArrayList<Integer>> prisePossible(int[][] plateau, int caseAVerifier) {
        ArrayList<ArrayList<Integer>> prisePossible = new ArrayList<ArrayList<Integer>>();
        int ligneCase = caseAVerifier / 10;
        int colonneCase = caseAVerifier % 10;
        int valeurCase = plateau[ligneCase][colonneCase];

        int codePieceQuiMange, codePieceMangee;

        if (valeurCase % VariablesGlobales.codePieceNoire == 0) {
            codePieceQuiMange = VariablesGlobales.codePieceNoire;
            codePieceMangee = VariablesGlobales.codePieceBlanche;
        } else if (valeurCase % VariablesGlobales.codePieceBlanche == 0) {
            codePieceQuiMange = VariablesGlobales.codePieceBlanche;
            codePieceMangee = VariablesGlobales.codePieceNoire;
        } else return prisePossible;

        int deplacementY = 1;
        int deplacementX = 1;
        for (int nombreDiagonales = 1; nombreDiagonales <= 4; nombreDiagonales++) {
            if (valeurCase % VariablesGlobales.codeDame != 0) {

                boolean conditionDansLesBordsY = (0 <= (ligneCase + 2 * (deplacementY)) && ((ligneCase + 2 * (deplacementY)) <= 9));
                boolean conditionDansLesBordsX = (0 <= (colonneCase + 2 * (deplacementX)) && ((colonneCase + 2 * (deplacementX)) <= 9));

                if (conditionDansLesBordsX && conditionDansLesBordsY) {
                    boolean conditionPeutManger = (plateau[ligneCase][colonneCase] % codePieceQuiMange == 0) &&
                            (plateau[ligneCase + deplacementY][colonneCase + deplacementX] % codePieceMangee == 0) &&
                            (plateau[ligneCase + 2 * deplacementY][colonneCase + 2 * deplacementX] == VariablesGlobales.codeCaseVide) &&
                            (plateau[ligneCase + deplacementY][colonneCase + deplacementX] % VariablesGlobales.codePiecePrise != 0); //Piece Marquee comme non prise
                    if (conditionPeutManger) {
                        int numeroLigneArrivee = ligneCase + 2 * deplacementY;
                        int numeroColonneArrivee = colonneCase + 2 * deplacementX;
                        int numeroLignePieceMangee = ligneCase + 1 * deplacementY;
                        int numeroColonnePieceMangee = colonneCase + 1 * deplacementX;

                        ArrayList<Integer> coupleNumeroCasePriseEtCaseArrivee = new ArrayList<Integer>();
                        coupleNumeroCasePriseEtCaseArrivee.add(numeroLignePieceMangee * 10 + numeroColonnePieceMangee);// Numéro de la case de la prise
                        coupleNumeroCasePriseEtCaseArrivee.add(numeroLigneArrivee * 10 + numeroColonneArrivee);// Numéro de la case d'arrivee

                        prisePossible.add(coupleNumeroCasePriseEtCaseArrivee);
                    }
                }
            }
            else {
                //cas Dame
                int deplacementCumuleX = deplacementX;
                int deplacementCumuleY = deplacementY;

                boolean conditionDansLesBordsY = (0 <= (ligneCase + 2 * (deplacementCumuleY)) && ((ligneCase + 2 * (deplacementCumuleY)) <= 9));
                boolean conditionDansLesBordsX = (0 <= (colonneCase + 2 * (deplacementCumuleX)) && ((colonneCase + 2 * (deplacementCumuleX)) <= 9));
                boolean espaceJusquaPriseVide = true;
                boolean aMangee = false;

                while(conditionDansLesBordsX && conditionDansLesBordsY && espaceJusquaPriseVide && !aMangee){
                    if(plateau[ligneCase + deplacementCumuleY][colonneCase + deplacementCumuleX] != VariablesGlobales.codeCaseVide) espaceJusquaPriseVide = false;

                    boolean conditionPeutManger = (plateau[ligneCase][colonneCase] % codePieceQuiMange == 0) &&
                            (plateau[ligneCase + deplacementCumuleY][colonneCase + deplacementCumuleX] % codePieceMangee == 0) &&
                            (plateau[ligneCase + deplacementY + deplacementCumuleY][colonneCase + deplacementX + deplacementCumuleX] == VariablesGlobales.codeCaseVide) &&
                            (plateau[ligneCase + deplacementCumuleY][colonneCase + deplacementCumuleX] % VariablesGlobales.codePiecePrise != 0);
                    if(conditionPeutManger){
                        int numeroLignePieceMangee = ligneCase +  deplacementCumuleY;
                        int numeroColonnePieceMangee = colonneCase +  deplacementCumuleX;
                        int numeroLigneArrivee = ligneCase + deplacementY + deplacementCumuleY;
                        int numeroColonneArrivee = colonneCase + deplacementX + deplacementCumuleX;

                        boolean caseArriveeVide = true;
                        boolean caseArriveeDansLesBordsX = true;
                        boolean caseArriveeDansLesBordsY = true;

                        while(caseArriveeVide && caseArriveeDansLesBordsX && caseArriveeDansLesBordsY){
                            ArrayList<Integer> coupleNumeroCasePriseEtCaseArrivee = new ArrayList<Integer>();
                            coupleNumeroCasePriseEtCaseArrivee.add(numeroLignePieceMangee * 10 + numeroColonnePieceMangee);
                            coupleNumeroCasePriseEtCaseArrivee.add(numeroLigneArrivee * 10 + numeroColonneArrivee);

                            prisePossible.add(coupleNumeroCasePriseEtCaseArrivee);

                            numeroColonneArrivee = deplacementX + numeroColonneArrivee;
                            numeroLigneArrivee = deplacementY + numeroLigneArrivee;

                            caseArriveeDansLesBordsY = (0 <= (numeroLigneArrivee) && ((numeroLigneArrivee) <= 9));
                            caseArriveeDansLesBordsX = (0 <= (numeroColonneArrivee) && ((numeroColonneArrivee) <= 9));
                            if(caseArriveeDansLesBordsX && caseArriveeDansLesBordsY){
                                caseArriveeVide = (plateau[numeroLigneArrivee][numeroColonneArrivee] == VariablesGlobales.codeCaseVide);
                            }
                        }
                        aMangee = true;
                    }
                    deplacementCumuleX = deplacementCumuleX + deplacementX;
                    deplacementCumuleY = deplacementCumuleY + deplacementY;

                    conditionDansLesBordsY = (0 <= (ligneCase + deplacementY + (deplacementCumuleY)) && ((ligneCase + deplacementY + (deplacementCumuleY)) <= 9));
                    conditionDansLesBordsX = (0 <= (colonneCase + deplacementX + (deplacementCumuleX)) && ((colonneCase + deplacementX + (deplacementCumuleX)) <= 9));

                }

            }

            //Permet de gerer le deplacement pour les différentes diagonales
            //La boucle commence par la diagonale inférieure droite et itere dans le sens des aiguilles d'une montre;
            if (nombreDiagonales % 2 == 0) {
                deplacementX = deplacementX * (-1);
            } else {
                deplacementY = deplacementY * (-1);
            }
        }
        return prisePossible;
    }

    public static void ajoutArbreDesPrises(ArrayList<ArrayList<Integer>> arbreDesPrises, int numeroCaseArrivee, int indexParent, int numeroCasePrise){
        ArrayList<Integer > priseCourante = new ArrayList<Integer>();
        priseCourante.add(numeroCaseArrivee);// Numéro de la case d'arrivée de la prise actuelle
        priseCourante.add(indexParent);// Numéro de la case du parent
        priseCourante.add(numeroCasePrise);// Numéro de la case de la pièce prise
        arbreDesPrises.add(priseCourante);
    }

    public static ArrayList<Integer> listeDesPrisesCumulees(ArrayList<ArrayList<Integer>> arbreDesPrises, int indice) {
        ArrayList<Integer> priseCumulee = new ArrayList<Integer>();
        while(indice > 0){
            int priseActuelle = arbreDesPrises.get(indice).get(2);
            priseCumulee.add(priseActuelle);
            indice = arbreDesPrises.get(indice).get(1);
        }
        return priseCumulee;
    }

    public static void marquePriseSurPlateau(int[][] plateau, ArrayList<Integer> listePrise){
        if(listePrise.size() != 0){
            for(int i = 0; i < listePrise.size(); i++){
                int lignePrise = listePrise.get(i) / 10;
                int colonnePrise = listePrise.get(i) % 10;
                plateau[lignePrise][colonnePrise] = plateau[lignePrise][colonnePrise] * VariablesGlobales.codePiecePrise;
            }
        }
    }

    public static void enleveMarquePriseSurPlateau(int[][] plateau, ArrayList<Integer> listePrise){
        if(listePrise.size() != 0){
            for(int i = 0; i < listePrise.size(); i++){
                int lignePrise = listePrise.get(i) / 10;
                int colonnePrise = listePrise.get(i) % 10;
                if(plateau[lignePrise][colonnePrise]%VariablesGlobales.codePiecePrise == 0){
                    plateau[lignePrise][colonnePrise] = plateau[lignePrise][colonnePrise] / VariablesGlobales.codePiecePrise;
                }
            }
        }
    }
}

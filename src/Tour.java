import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Tour {
    public static Scanner scanner = new Scanner(System.in);

    /**
     * Fonction vérifiant  les prises majoritaires possibles pour les pièces du joueur et définit le nombre de prises(pièces à prendre) possibles.
     * Si 0 prise --> l'utilisateur doit effectuer un déplacement simple légal.
     * Si 1 prise --> MAJ du plateau : la case de la pièce mangee prend la valeur 11;
     * Si +1 prises --> l'utilisateur a entamé une rafle et doit poursuivre jusqu'à l'avoir finie en saisissant de nouvelles cases d'arrivées.
     *
     * @param plateau    => plateau de jeu
     * @param typeJoueur => joueur actuel : 05 si blanc et 03 si noir
     * @return -1 si l'utilisateur veut quitter / return 0 si l'utilisateur choisie des cases d'arrivée et de départ correctes.
     */
    public static int deroulementTour(int[][] plateau, int typeJoueur){

        ArrayList<ArrayList<ArrayList<Integer>>> listeDesPrisesMajoPourPossibleCeTour = listeDesDifferentsCheminsPriseMajoPossiblePourChaquePieceDuPlateau(plateau,typeJoueur);
        int nombrePrisesMax = 0;
        if(listeDesPrisesMajoPourPossibleCeTour.size() !=0)
        {
            nombrePrisesMax = (listeDesPrisesMajoPourPossibleCeTour.get(0).get(0).size()-1)/2;
        }

        if(nombrePrisesMax == 0) { //Il n'y a aucune prise possible pour aucune piece pour ce tour;
            int caseDepart, caseArrivee;

            System.out.print(VariablesGlobales.messageSaisieCaseDepart);
            caseDepart = saisieForceeManoury();
            if (caseDepart == -1) return -1;
            caseDepart = conversionManouryTableau(caseDepart);

            System.out.print(VariablesGlobales.messageSaisieCaseArrivee);
            caseArrivee = saisieForceeManoury();
            if (caseArrivee == -1) return -1;
            caseArrivee = conversionManouryTableau(caseArrivee);

            int codeLegalite = legaliteMouvement(plateau,caseDepart,caseArrivee,typeJoueur);
            boolean estPasUnDeplacement = (codeLegalite != VariablesGlobales.codeMouvementPionSansPrise) && (codeLegalite != VariablesGlobales.codeMouvementDameSansPrise);
            while(estPasUnDeplacement == true){
                if(codeLegalite == VariablesGlobales.codeErreurCaseDepartVide){
                    System.out.println(VariablesGlobales.messageErreurCaseDepartVide);
                }
                else if (codeLegalite == VariablesGlobales.codeErreurCaseArriveeNonVide){
                    System.out.println(VariablesGlobales.messageErreurCaseArriveeNonVide);
                }
                else if (codeLegalite == VariablesGlobales.codeErreurPieceAppartenantAdversaire){
                    System.out.println(VariablesGlobales.messageErreurPieceAppartenantAdversaire);
                }
                else if (codeLegalite < 0){
                    System.out.println("Mouvement interdit");
                }

                System.out.print(VariablesGlobales.messageReSaisieCaseDepart);
                caseDepart = saisieForceeManoury();
                if (caseDepart == -1) return -1;
                caseDepart = conversionManouryTableau(caseDepart);


                System.out.print(VariablesGlobales.messageReSaisieCaseArrivee);
                caseArrivee = saisieForceeManoury();
                if (caseArrivee == -1) return -1;
                caseArrivee = conversionManouryTableau(caseArrivee);

                codeLegalite = legaliteMouvement(plateau,caseDepart,caseArrivee,typeJoueur);
                estPasUnDeplacement = (codeLegalite != VariablesGlobales.codeMouvementPionSansPrise) && (codeLegalite != VariablesGlobales.codeMouvementDameSansPrise);

            }

            int ligneDepart = caseDepart / 10;
            int colonneDepart = caseDepart %10;
            int ligneArrivee = caseArrivee / 10;
            int colonneArrivee = caseArrivee %10;

            plateau[ligneArrivee][colonneArrivee] = plateau[ligneDepart][colonneDepart];
            plateau[ligneDepart][colonneDepart] = VariablesGlobales.codeCaseVide;
        }
        else{ //Simple prise ou rafle

            int caseDepart, caseArrivee;

            System.out.print(VariablesGlobales.messageSaisieCaseDepart);
            caseDepart = saisieForceeManoury();
            if (caseDepart == -1) return -1;
            caseDepart = conversionManouryTableau(caseDepart);

            System.out.print(VariablesGlobales.messageSaisieCaseArrivee);
            caseArrivee = saisieForceeManoury();
            if (caseArrivee == -1) return -1;
            caseArrivee = conversionManouryTableau(caseArrivee);


            int codeLegalite = legaliteMouvement(plateau,caseDepart,caseArrivee,typeJoueur);
            int casePieceMangee = positionPiecePrise(caseDepart,caseArrivee,listeDesPrisesMajoPourPossibleCeTour);
            boolean estPasUnePrise = (casePieceMangee == -1);
            while(estPasUnePrise == true){
                if(codeLegalite == VariablesGlobales.codeErreurCaseDepartVide){
                    System.out.println(VariablesGlobales.messageErreurCaseDepartVide);
                }
                else if (codeLegalite == VariablesGlobales.codeErreurCaseArriveeNonVide){
                    System.out.println(VariablesGlobales.messageErreurCaseArriveeNonVide);
                }
                else if (codeLegalite == VariablesGlobales.codeErreurPieceAppartenantAdversaire){
                    System.out.println(VariablesGlobales.messageErreurPieceAppartenantAdversaire);
                }
                else if (codeLegalite < 0){
                    System.out.println("Mouvement interdit");
                }
                else if(codeLegalite == VariablesGlobales.codeMouvementPionSansPrise || codeLegalite == VariablesGlobales.codeMouvementDameSansPrise)
                {
                    System.out.println("Vous devez privilégier une prise");
                }
                else{
                    System.out.println("Vous devez privilégier la prise majoritaire");
                }

                System.out.print(VariablesGlobales.messageReSaisieCaseDepart);
                caseDepart = saisieForceeManoury();
                if (caseDepart == -1) return -1;
                caseDepart = conversionManouryTableau(caseDepart);

                System.out.print(VariablesGlobales.messageReSaisieCaseArrivee);
                caseArrivee = saisieForceeManoury();
                if (caseArrivee == -1) return -1;
                caseArrivee = conversionManouryTableau(caseArrivee);

                codeLegalite = legaliteMouvement(plateau,caseDepart,caseArrivee,typeJoueur);
                casePieceMangee = positionPiecePrise(caseDepart,caseArrivee,listeDesPrisesMajoPourPossibleCeTour);
                estPasUnePrise = (casePieceMangee == -1);
            }


            miseAJourPlateauDeplacement(plateau, caseDepart, caseArrivee);

            listeCheminsCaseDepartChoisie(caseDepart,listeDesPrisesMajoPourPossibleCeTour);


            if(nombrePrisesMax == 1)
            {
                int lignePieceMangee = casePieceMangee /10;
                int colonnePieceMangee = casePieceMangee %10;
                plateau[lignePieceMangee][colonnePieceMangee] = VariablesGlobales.codeCaseVide;
            }
            else{
                listeCheminsCaseArriveeChoisie(caseArrivee,1,listeDesPrisesMajoPourPossibleCeTour);

                //marque 1ere prise
                int casePrise1 = listeDesPrisesMajoPourPossibleCeTour.get(0).get(0).get(1);
                plateau[casePrise1/10][casePrise1%10] = plateau[casePrise1/10][casePrise1%10] * VariablesGlobales.codePiecePrise;

                Plateau.afficherDamier(plateau);

                System.out.println("Vous avez entamé une rafle");

                int nouvelleCaseDepart;

                for(int nombrePriseEffectuee = 1; nombrePriseEffectuee < nombrePrisesMax; nombrePriseEffectuee++){
                    nouvelleCaseDepart = caseArrivee;
                    System.out.println("Il vous reste " + (nombrePrisesMax - nombrePriseEffectuee) + " prise(s) à effectuer");

                    System.out.print("Prises possibles : ");
                    ArrayList<Integer> listePrisePossibleActuelle = listePrisePossibleRafle(nombrePriseEffectuee*2, listeDesPrisesMajoPourPossibleCeTour);
                    for(int i=0; i < listePrisePossibleActuelle.size(); i++ ){
                        System.out.print(conversionTableauManoury(listePrisePossibleActuelle.get(i)));
                        if(i < (listePrisePossibleActuelle.size() - 1)) System.out.print(" , ");
                    }
                    System.out.println();
                    System.out.print(VariablesGlobales.messageSaisieCaseArrivee);
                    caseArrivee = saisieForceeManoury();
                    if (caseArrivee == -1) return -1;
                    caseArrivee = conversionManouryTableau(caseArrivee);

                    boolean appartientAPriseMajo = listeCheminsCaseArriveeChoisie(caseArrivee,(nombrePriseEffectuee+1),listeDesPrisesMajoPourPossibleCeTour);

                    while(!appartientAPriseMajo){
                        System.out.println("Le mouvement demandé n'est pas appartient pas à la prise majoritaire");
                        System.out.print(VariablesGlobales.messageReSaisieCaseArrivee);
                        caseArrivee = saisieForceeManoury();
                        if (caseArrivee == -1) return -1;
                        caseArrivee = conversionManouryTableau(caseArrivee);

                        appartientAPriseMajo = listeCheminsCaseArriveeChoisie(caseArrivee,(nombrePriseEffectuee+1),listeDesPrisesMajoPourPossibleCeTour);
                    }

                    //Marque Prise
                    int casePriseRafle = listeDesPrisesMajoPourPossibleCeTour.get(0).get(0).get(nombrePriseEffectuee*2+1);
                    int valeurPiecePrise = plateau[casePriseRafle/10][casePriseRafle%10];
                    //System.out.println("casePriseRafle : "+ casePriseRafle);
                    //System.out.println("valeurPieceRafle : "+ valeurPiecePrise);
                    plateau[casePriseRafle/10][casePriseRafle%10] = valeurPiecePrise * VariablesGlobales.codePiecePrise;

                    miseAJourPlateauDeplacement(plateau, nouvelleCaseDepart, caseArrivee);
                    if(nombrePriseEffectuee < (nombrePrisesMax -1) ) Plateau.afficherDamier(plateau);
                }

                for(int i = 1; i < listeDesPrisesMajoPourPossibleCeTour.get(0).get(0).size() ; i = i + 2){
                    int casePiecePrise = listeDesPrisesMajoPourPossibleCeTour.get(0).get(0).get(i);
                    plateau[casePiecePrise/10][casePiecePrise%10] = VariablesGlobales.codeCaseVide;
                }

                //if(nombrePrisesMax > 1 ) Plateau.afficherDamier(plateau);

            }

        }

        return 0;
    }

    /**
     *
     * Fonction qui effectue une converion entre la case saisie en manoury et les indices ligne/colonne d'un tableau de int 2D (int[][]).
     *
     * @param indiceManoury => numéro de case manoury (compris entre 1 et 50)
     * @return la position de la case dans le tableau : le chiffre des dizaines correspond à la ligne et le chiffre des unités à la colonne
     */
    public static int conversionManouryTableau(int indiceManoury){
        int chiffreADroite = indiceManoury % 10;

        if(chiffreADroite <= 5 && chiffreADroite != 0) return indiceManoury * 2 - 1;
        else return indiceManoury * 2 -2;
    }
    /**
     * Fonction qui effectue une conversion entre la position ligne/colonne d'une case d'un tableau 2D en une case Manoury (entre 1 et 50).
     *
     * @param indiceTableau => position de la case dans le tableau de int[][] (le chiffre des dizaines correspond à la ligne et le chiffre des unités à la colonne)
     * @return la position de la case en notation Manoury
     */
    public static int conversionTableauManoury(int indiceTableau){
        int ligne = indiceTableau / 10;
        int colonne = indiceTableau % 10;

        if(ligne%2 == 0) return (ligne * 5) + ((colonne + 1)/2);
        else return (ligne * 5) + ((colonne + 2)/2);
    }

    /**
     * Fonction obligeant l'utilisateur à saisie une case entre numérotée entre 1 et 50 compris.
     *
     * @return l'entier saisie par l'utilisateur qui peut être --> une case manoury / -1 s'il veut quitter.
     */
    public static int saisieForceeManoury(){
        int nombreSaisie = scanner.nextInt();
        while(((1 > nombreSaisie) || (nombreSaisie > 50)) && (nombreSaisie != -1)){
            System.out.print("Veuillez saisir un nombre entre 1 et 50 ou -1 pour abandonner : ");
            nombreSaisie = scanner.nextInt();
            System.out.println();
        }
        return nombreSaisie;
    }

    /**
     * Cette méthode intervient à partir du 2ème tour de rafle
     * Cette fonction regarde la liste des prises majoritaires pour ce tour et ajoute à la liste des prisesRafle la 1ère pièce pouvant être mangée par la case de départ choisie :
     * => la première prise rencontrée dans la liste.
     * puis parcourt les autres sous-listes (autant et ajout des cases pouvant être mangées si leur valeur (position sur plateau) est différente.
     *
     * @param indiceDeListePourCaseDepart         => position de la nouvelle case de départ demandée dans la liste des prisesMajo.
     * @param listeCheminsPlateau => liste des chemins de prise majoritaire pour la pièce de départ du joueur actuel
     * @return listeDesPrises les cases des pièces pouvant être mangées par la case de départ de choisie
     */
    public static ArrayList<Integer> listePrisePossibleRafle(int indiceDeListePourCaseDepart, ArrayList<ArrayList<ArrayList<Integer>>> listeCheminsPlateau){
        ArrayList<Integer> listeDesPrises = new ArrayList<>();
        listeDesPrises.add(listeCheminsPlateau.get(0).get(0).get(indiceDeListePourCaseDepart+1));
        int i = 1;

        while(i < listeCheminsPlateau.get(0).size() && listeDesPrises.size() <= 3){
            int priseActuelle = listeCheminsPlateau.get(0).get(i).get(indiceDeListePourCaseDepart+1);
            boolean estUnique = true;

            for(int j = 0; j < listeDesPrises.size(); j++){
                if(priseActuelle == listeDesPrises.get(j)){
                    estUnique = false;
                }
            }
            if(estUnique) listeDesPrises.add(priseActuelle);
            i++;
        }
        return listeDesPrises;
    }

    /**
     * Méthode qui modifie le plateau :
     * => la case d'arrivée prend la valeur de la case de départ
     * => la case de départ devient vide (valeur de 11)
     *
     * @param plateau     => plateau de jeu actuel
     * @param caseDepart  => case départ demandée par l'utilisateur
     * @param caseArrivee => case d'arrivée demandée par l'utilisateur
     */
    public static void miseAJourPlateauDeplacement(int[][]  plateau, int caseDepart, int caseArrivee){
        int ligneDepart = caseDepart / 10;
        int colonneDepart = caseDepart %10;
        int ligneArrivee = caseArrivee / 10;
        int colonneArrivee = caseArrivee %10;

        plateau[ligneArrivee][colonneArrivee] = plateau[ligneDepart][colonneDepart];
        plateau[ligneDepart][colonneDepart] = VariablesGlobales.codeCaseVide;
    }

    /**
     * Méthode qui modifie la liste des prises majoritaires pour ce tour :
     * En vérifiant que la case de départ saisie par l'utilisateur possède une prise majoritaire (la case est présente dans la liste des prises majoritaires pour ce tour)
     * Si c'est le cas, la méthode parcourt la liste des prises majoritaires de ce tour et supprime celles qui ne découlent pas de la case départ demandée.
     *
     * @param caseDepart => case départ demandée par l'utilisateur
     * @param listeCheminsPlateau => liste des chemins des prises majoritaires possibles pour les pièces du joueur ayant une prise majoritaire.
     */
    //Elle enleve les "parentheses" des autres cases de depart uniquement si la case de depart choisi existe
    public static void listeCheminsCaseDepartChoisie(int caseDepart, ArrayList<ArrayList<ArrayList<Integer>>> listeCheminsPlateau){
        int indice = 0;
        boolean horsDomaine = false;
        boolean aTrouve = false;
        while(aTrouve == false && horsDomaine == false){

            aTrouve = listeCheminsPlateau.get(indice).get(0).get(0) == caseDepart;
            if(aTrouve){
                for (int i = (listeCheminsPlateau.size() - 1) ; i >= 0 ; i--){
                    if(listeCheminsPlateau.get(i).get(0).get(0) != caseDepart){
                        listeCheminsPlateau.remove(i);
                    }
                }
            }
            indice++;
            horsDomaine = indice >= listeCheminsPlateau.size();

        }
    }

    /**
     * Fonction qui parcourt les sous-listes de la liste des prises majoritaires de la case de départ initiale.
     * Puis vérifie si la nouvelle case d'arrivée choisie est bien dans la liste des prises majoritaires de la case de départ initiale.
     * Si oui, la fonction modifie la liste des prises majoritaire de ce tour (déjà réduite à la liste des prises majoritaires de la case de départ) afin de supprimer les sous-listes qui ne contiennent pas la nouvelle case d'arrivée demandée.
     *
     * @param caseArrivee                                            => Nouvelle case d'arrivée choisie par l'utilisateur lors d'une rafle.
     * @param numeroPrise                                                    => Numéro de la prise effectuée lors d'une rafle.
     * @param listeCheminsPlateau => liste des prises majoritaires possibles de ce tour (réduite à la liste des prises majoritaires la case de départ initiale)
     * @return true si la case d'arrivée choisie est bien une case appartenant à une des prises majoritaires de la case de départ et permet un déplacement qui poursuit la rafle.
     * false si la case d'arrivée (et donc le déplacement demandé) ne permet pas de poursuivre la rafle depuis la case de départ.
     */
    public static boolean listeCheminsCaseArriveeChoisie(int caseArrivee, int numeroPrise, ArrayList<ArrayList<ArrayList<Integer>>> listeCheminsPlateau){
        int indice = 0;
        boolean horsDomaine = false;
        boolean aTrouve = false;
        while(aTrouve == false && horsDomaine == false){

            aTrouve = listeCheminsPlateau.get(0).get(indice).get(numeroPrise*2) == caseArrivee;
            if(aTrouve){
                for (int i = (listeCheminsPlateau.get(0).size() - 1) ; i >= 0 ; i--){
                    if(listeCheminsPlateau.get(0).get(i).get(numeroPrise*2) != caseArrivee){
                        listeCheminsPlateau.get(0).remove(i);
                    }
                }
            }
            indice++;
            horsDomaine = indice >= listeCheminsPlateau.get(0).size();

        }
        return aTrouve;
    }

    /**
     *Fonction qui retourne la position d'une pièce mangée par un déplacement entre une case de départ et une case d'arrivée :
     * Pour cela, la fonction vérifie que la case de départ demandée par le joueur mène à une prise majoritaire donc appartient à la liste des prises majo de ce tour (case présente en position 0).
     * Si c'est le cas, la fonction vérifie que la case d'arrivée correspond bien à une case d'arrivée liée à une prise majoritaire de la case de départ : c.a.d qu'elle est dans la même sous-liste que la case départ, 2 positions plus loin. (indice 2)
     * Si c'est le cas, la fonction sélectionne l'indice 1 de la liste correspondant à la pièce qui serait mangée (par le déplacement de la case de départ à la case d'arrivée) et nous retourne le contenu de la liste à cet indice.
     *
     * @param caseDepart                            => case départ demandée par le joueur
     * @param caseArrivee                           => case arrivee demandée par le joueur
     * @param listeDesPrisesMajoPourCeTour liste des prises majoritaires pour les pièces appartenant au joueur actuel
     * @return => la position de la première pièce mangée SI la case de départ choisie appartient à la liste des prises maj
     *           -1 si la case de départ choisie ne mène pas à une prise majoritaire
     */
    public static int positionPiecePrise(int caseDepart, int caseArrivee, ArrayList<ArrayList<ArrayList<Integer>>> listeDesPrisesMajoPourCeTour){
        for(int i = 0; i < listeDesPrisesMajoPourCeTour.size(); i++){
            if(listeDesPrisesMajoPourCeTour.get(i).get(0).get(0) == caseDepart){
                for(int j = 0; j < listeDesPrisesMajoPourCeTour.get(i).size() ; j++){
                    if(listeDesPrisesMajoPourCeTour.get(i).get(j).get(2) == caseArrivee) {
                        return listeDesPrisesMajoPourCeTour.get(i).get(j).get(1);
                    }
                }
            }
        }
        return -1;
    }

    /**
     *
     * Fonction qui retourne une liste  à 3D.
     * 1ère dimensions : les cases à jouer (case de départ, case mangée, case d'arrivée, case mangée, case d'arrivée etc.)
     * 2ème dimensions : les différentes possibilités de prises majoritaires pour une pièce appartenant au joueur actuel. (toute de la même taille : taille du chemin maximum)
     * 3ème dimensions : regroupement des sous listes de chacune des pièces pour former une liste de prises majoritaires pour toutes les pièces du plateau appartenant au joueur actuel pouvant mener à une prise majoritaire.
     *
     * Pour cela, la fonction parcourt le tableau. A chaque renconter avec une pièce du joueur actuel, elle construit l'arbre des prises majoritaires en appelant la méthode PriseMajoritaireMethodes.cheminsPriseMajoritaire.
     * Elle compare la taille du chemin obtenu à la taille maximum du chemin de prise(s) majoritaire(s) déjà trouvée. Si la taille du chemin actuel est supérieur, elle devient le nouveau maximum (chemin le plus grand).
     *
     * La fonction initialise une liste qui va contenir les sous listes de chacune des pièces pour former une liste de prises majoritaires pour toutes les pièces du plateau appartenant au joueur actuel pouvant mener à une prise majoritaire.
     * Si le maximum précédemment trouvé est différent de 0 alors, la fonction parcourt une 2ème fois le plateau et ajoute les chemins de prises majoritaires des pièces du joueur ayant une longueur maximum.
     *
     * @param plateau    => plateau de jeu
     * @param typeJoueur => joueur actuel --> 05 pour  blanc et 03 pour noir
     * @return => une liste 3D de int représentant les prises majoritaires pour chaque piece du plateau appartenant au joueur.
     *          --> la liste est de taille 0 s'il n'y a pas de prise majoritaire (= que des déplacements simples)
     *
     */
    public static ArrayList<ArrayList<ArrayList<Integer>>> listeDesDifferentsCheminsPriseMajoPossiblePourChaquePieceDuPlateau(int[][] plateau, int typeJoueur) {
        int maximum = 0;
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[i].length; j++) {
                if (plateau[i][j] % typeJoueur == 0) {
                    int caseDepart = i * 10 + j;
                    if (PriseMajoritaireMethodes.cheminsPriseMajoritaire(plateau, caseDepart).size() != 0 && PriseMajoritaireMethodes.cheminsPriseMajoritaire(plateau, caseDepart).get(0).size() > maximum) {
                        maximum = PriseMajoritaireMethodes.cheminsPriseMajoritaire(plateau, caseDepart).get(0).size();

                    }
                }

            }
        }
        ArrayList<ArrayList<ArrayList<Integer>>> listeDesDifferentsCheminsPossiblePourChaquePieceDuPlateau = new ArrayList<>();

        if(maximum != 0){
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[i].length; j++) {
                if (plateau[i][j] % typeJoueur == 0) {
                    int caseDepart = i * 10 + j;
                    if (PriseMajoritaireMethodes.cheminsPriseMajoritaire(plateau, caseDepart).size() != 0 && PriseMajoritaireMethodes.cheminsPriseMajoritaire(plateau, caseDepart).get(0).size() == maximum) {
                        listeDesDifferentsCheminsPossiblePourChaquePieceDuPlateau.add(PriseMajoritaireMethodes.cheminsPriseMajoritaire(plateau, caseDepart));
                    }
                }
            }
        }}

        return listeDesDifferentsCheminsPossiblePourChaquePieceDuPlateau;
    }

    /**
     *
     * Fonction qui analyse les déplacement demandée par le joueur via le contenu de sa case départ et de sa case d'arrivée et renvoie un code erreur si le déplacement n'est pas autorisé.
     * Le code erreur est spécifique selon l'erreur provoquée par le déplacement demandé.
     *
     * @param plateau => plateau de jeu
     * @param caseDepart => case départ demandée par le joueur
     * @param caseArrivee => case d'arrivée demandée par le joueur
     * @param typeJoueur => joueur actuel --> 05 pour blanc et 03 pour noir
     * @return un code indiquant une erreur
     */
    public static int legaliteMouvement(int[][] plateau, int caseDepart, int caseArrivee, int typeJoueur){
        int ligneCaseDepart = caseDepart/10;
        int colonneCaseDepart = caseDepart%10;
        int ligneCaseArrivee = caseArrivee/10;
        int colonneCaseArrivee = caseArrivee%10;

        int deltaLigne = ligneCaseArrivee - ligneCaseDepart;
        int deltaColonne = colonneCaseArrivee - colonneCaseDepart;

        if(plateau[ligneCaseDepart][colonneCaseDepart] == VariablesGlobales.codeCaseVide)
            return  VariablesGlobales.codeErreurCaseDepartVide;
        else if(plateau[ligneCaseArrivee][colonneCaseArrivee] != VariablesGlobales.codeCaseVide)
            return VariablesGlobales.codeErreurCaseArriveeNonVide;
        else if(plateau[ligneCaseDepart][colonneCaseDepart]%typeJoueur != 0)
            return VariablesGlobales.codeErreurPieceAppartenantAdversaire;
        else if(FonctionsDiverses.valeurAbsolue(deltaLigne) != FonctionsDiverses.valeurAbsolue(deltaColonne) || deltaLigne == 0 || deltaColonne == 0)
            return VariablesGlobales.codeErreurMouvementNonDiagonal;

            //Cas Pion
        else if(plateau[ligneCaseDepart][colonneCaseDepart]%VariablesGlobales.codeDame != 0) {
            int amplitudeDeplacement = FonctionsDiverses.valeurAbsolue(deltaLigne);
            if (amplitudeDeplacement > 2) {
                return VariablesGlobales.codeErreurMouvementPionImpossible;
            }
            else if (amplitudeDeplacement == 2)
            {
                int deplacementColonne = deltaColonne / amplitudeDeplacement;
                int deplacementLigne = deltaLigne / amplitudeDeplacement;

                int codePieceAdverse;
                if(typeJoueur == VariablesGlobales.codePieceBlanche) codePieceAdverse = VariablesGlobales.codePieceNoire;
                else codePieceAdverse = VariablesGlobales.codePieceBlanche;

                boolean priseEstUnePieceAdverse = (plateau[ligneCaseDepart + deplacementLigne][colonneCaseDepart + deplacementColonne]%codePieceAdverse == 0);

                if(priseEstUnePieceAdverse) return VariablesGlobales.codeMouvementPionAvecPrise;
                else return VariablesGlobales.codeErreurMouvementPionImpossible;
            }
            else{
                if(plateau[ligneCaseDepart][colonneCaseDepart]%VariablesGlobales.codePieceNoire == 0 && deltaLigne == 1)
                    return VariablesGlobales.codeMouvementPionSansPrise;
                else if (plateau[ligneCaseDepart][colonneCaseDepart]%VariablesGlobales.codePieceBlanche == 0 && deltaLigne == -1)
                    return VariablesGlobales.codeMouvementPionSansPrise;
                else
                    return VariablesGlobales.codeErreurMouvementPionImpossible;
            }
        }
        //Cas Dame
        else{
            int amplitudeDeplacement = FonctionsDiverses.valeurAbsolue(deltaLigne);
            int deplacementUnitaireLigne = deltaLigne / amplitudeDeplacement;
            int deplacementUnitaireColonne = deltaColonne / amplitudeDeplacement;

            int nombreCaseVides = 0;
            int nombrePieceAdversaire = 0;

            int codePieceAdverse;
            if(typeJoueur == VariablesGlobales.codePieceBlanche) codePieceAdverse = VariablesGlobales.codePieceNoire;
            else codePieceAdverse = VariablesGlobales.codePieceBlanche;

            for(int deplacementCumule = 1; deplacementCumule < amplitudeDeplacement; deplacementCumule++){
                if(plateau[ligneCaseDepart + (deplacementCumule * deplacementUnitaireLigne)][colonneCaseDepart + (deplacementCumule * deplacementUnitaireColonne)]%VariablesGlobales.codeCaseVide == 0)
                    nombreCaseVides++;
                else if (plateau[ligneCaseDepart + (deplacementCumule * deplacementUnitaireLigne)][colonneCaseDepart + (deplacementCumule * deplacementUnitaireColonne)]%codePieceAdverse == 0)
                    nombrePieceAdversaire++;
            }

            if(nombreCaseVides + 1 == amplitudeDeplacement) return VariablesGlobales.codeMouvementDameSansPrise;
            else if ((nombrePieceAdversaire == 1) && (amplitudeDeplacement == nombrePieceAdversaire + nombreCaseVides + 1)) return VariablesGlobales.codeMouvementDameAvecPrise;
            else return VariablesGlobales.codeErreurMouvementDameImpossible;
        }
    }
}

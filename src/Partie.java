public class Partie {

    /*
     * Méthode qui définit le 1er joueur. Puis, tant qu'il n'y a pas de gagnant ni d'abandon effectue des boucles de tour de jeu.
     * La méthode affiche le damier, effectue un déroulement puis vérifie s'il doit y avoir des promotions en dame.
     * Enfin, la méthode fait alterner le joueur actuel.
     *
     * @param plateauDepart => plateau de jeu vierge /démo
     *
     *
     */

    /**
     * Méthode qui définit le 1er joueur. Puis, tant qu'il n'y a pas de gagnant ni d'abandon effectue des boucles de tour de jeu.
     * La méthode affiche le damier, effectue un déroulement puis vérifie s'il doit y avoir des promotions en dame.
     * Enfin, la méthode fait alterner le joueur actuel.
     *
     * @param plateauDepart => plateau de jeu vierge /démo
     * @param premierJoueur => type premier joueur
     */
    public static void lancerPartie(int[][] plateauDepart, int premierJoueur){

        System.out.println("Pour abandonner la partie, entrez -1 lors d'une saisie");

        int typeJoueur = premierJoueur;
        int gagnantPartie = -1;
        int retourDeroulementTour;
        boolean abandon = false;

        while (gagnantPartie == -1){
            if(typeJoueur == VariablesGlobales.codeJoueurUn){
                System.out.println("Tour du joueur 1");
            }
            else System.out.println("Tour du joueur 2");

            Plateau.afficherDamier(plateauDepart);
            retourDeroulementTour = Tour.deroulementTour(plateauDepart,typeJoueur);
            promotionDame(plateauDepart,typeJoueur);
            if(retourDeroulementTour == -1) abandon = true;
            gagnantPartie = gagnant(plateauDepart,typeJoueur, abandon);

            if(typeJoueur == VariablesGlobales.codeJoueurUn) typeJoueur = VariablesGlobales.codeJoueurDeux;
            else typeJoueur = VariablesGlobales.codeJoueurUn;
        }

        Plateau.afficherDamier(plateauDepart);

        if(gagnantPartie == VariablesGlobales.codeJoueurUn){
            System.out.println("Le gagnant est le joueur 1");
        }
        else{
            System.out.println("Le gagnant est le joueur 2");
        }
        System.out.println();
    }

    /**
     * La procédure vérifie si un pion blanc (05) est placé sur une colonne de la ligne 0. Si oui, elle change sa valeur en codeDameBlanche (05 * 2 = 10)
     * si un pion noir (03) est placé sur une colonne de la ligne 9. Si oui, elle change sa valeur en codeDameBlanche (03 * 2 = 06)
     *
     * @param plateau => plateau de jeu.
     * @param typeJoueur => joueur actuel (03 pour noir ou 05 pour blanc
     */
    public static void promotionDame(int[][] plateau, int typeJoueur){
        if(typeJoueur == VariablesGlobales.codeJoueurUn){
            for (int indiceColonne = 1; indiceColonne < 10; indiceColonne = indiceColonne + 2){
                if(plateau[0][indiceColonne] == VariablesGlobales.codePionBlanc){
                    plateau[0][indiceColonne] = plateau[0][indiceColonne] * VariablesGlobales.codeDame;
                }
            }
        }
        else {
            for (int indiceColonne = 0; indiceColonne < 10; indiceColonne = indiceColonne + 2){
                if(plateau[9][indiceColonne] == VariablesGlobales.codePionNoir){
                    plateau[9][indiceColonne] = plateau[9][indiceColonne] * VariablesGlobales.codeDame;
                }
            }

        }

    }
    /*
     *
     * La fonction indique l'existence d'un gagnant (typeJoueurActuel) ou pas (-1).
     * Pour cela, elle vérifie si le joueur actuel a abandonnée --> Si oui, la fonction renvoie le code correspondant au joueur adverse (si joueur actuel = 05, code adverse = 03 et inversement)
     * S'il n'y a pas d'abandon, elle vérifie sur le plateau l'existence de pièces adverses. A chaque rencontre d'une pièce adverse,
     * la méthode vérifie que cette pièce est bloquée (aucun déplacement possible).
     * Tant qu'elle n'a pas trouvé une pièce adverse en capacité de bouger, la fonction continue d'en chercher une.
     *
     * @param plateau => plateau de jeu.
     * @param typeJoueurActuel => 03 pour le joueur noir ou 05 pour le joueur blanc.
     * @return -1 s'il n'y a pas de gagnant (le joueur adverse possède au moins une pièce en capacité de se déplacer)
     *          la valeur du joueur actuel (qui est alors le gagnant --> l'adversaire n'a plus de pièce ou bien plus de pièce pouvant se déplacer)
     */

    /**
     * La fonction indique l'existence d'un gagnant (typeJoueurActuel) ou pas (-1).
     * Pour cela, elle vérifie si le joueur actuel a abandonnée --> Si oui, la fonction renvoie le code correspondant au joueur adverse (si joueur actuel = 05, code adverse = 03 et inversement)
     * S'il n'y a pas d'abandon, elle vérifie sur le plateau l'existence de pièces adverses. A chaque rencontre d'une pièce adverse,
     * la méthode vérifie que cette pièce est bloquée (aucun déplacement possible).
     * Tant qu'elle n'a pas trouvé une pièce adverse en capacité de bouger, la fonction continue d'en chercher une.
     *
     * @param plateau => plateau de jeu
     * @param typeJoueur  => 03 pour le joueur noir ou 05 pour le joueur blanc
     * @param joueurActuelAbandon => Si le joueur actuel a abandonné
     * @return -1 s'il n'y a pas de gagnant (le joueur adverse possède au moins une pièce en capacité de se déplacer)
     *      *          la valeur du joueur actuel (qui est alors le gagnant --> l'adversaire n'a plus de pièce ou bien plus de pièce pouvant se déplacer)
     */
    public static int gagnant(int[][] plateau, int typeJoueur, boolean joueurActuelAbandon){

        if(joueurActuelAbandon == true){
            if (typeJoueur == VariablesGlobales.codeJoueurUn) return VariablesGlobales.codeJoueurDeux;
            else return VariablesGlobales.codeJoueurUn;
        }

        int typePieceAVerifie;
        if(typeJoueur == VariablesGlobales.codeJoueurUn) typePieceAVerifie = VariablesGlobales.codePieceNoire;
        else typePieceAVerifie = VariablesGlobales.codePieceBlanche;

        //int nombrePiecesAdversaire = 0;

        boolean toutesLesPiecesSontBloquees = true;
        for(int indiceLigne = 0; indiceLigne < 10; indiceLigne++){
            int decalage = 0;
            if(indiceLigne%2 == 0) decalage = 1;
            for (int indiceColonne = 0 + decalage; indiceColonne < 10; indiceColonne = indiceColonne + 2 ){
                if(plateau[indiceLigne][indiceColonne]%typePieceAVerifie == 0){
                    int caseActuelle = indiceLigne * 10 + indiceColonne;
                    boolean pieceActuelleBloque = estBloquee(plateau,caseActuelle);
                    if(pieceActuelleBloque){
                        toutesLesPiecesSontBloquees = toutesLesPiecesSontBloquees && pieceActuelleBloque;
                    }
                    else return -1;
                }
            }
        }

        if(toutesLesPiecesSontBloquees) return typeJoueur;
        else return -1;

//        return typeJoueur;
    }

    /**
     * La fonction indique si une pièce est bloquée (true) ou pas (false).
     * La fonction vérifie que la pièce sur  ne peut effectuer aucune prise. Puis elle vérifie les déplacements simples :
     * D'abord pour une dame, la fonction vérifie si les cases directement en diagonale de la dame ne sont pas vides --> dame bloquée
     * Pour un pion noir, il s'agit de vérifier les diagonales directes vers le bas.
     * Pour un pion blanc, il s'agit de vérifier les diagonales directes vers le haut.
     * Si ces cases ne sont pas vides alors le pion ne peut pas se déplacer.
     *
     * @param plateau => plateau de jeu.
     * @param caseAVerifier => indice de la case dont on souhaite savoir si elle est bloquée
     * @return vraie si la case est bloquée
     *          false si la case n'est pas bloquée (elle peut effectuer un déplacement simple ou une prise)
     */
    public static boolean estBloquee(int[][] plateau, int caseAVerifier){

        if(PriseMajoritaireMethodes.prisePossible(plateau, caseAVerifier).size() == 0){
            int ligneCaseAVerifier = caseAVerifier / 10;
            int colonneCaseAVerfier = caseAVerifier % 10;
            int sensX = -1;
            int sensY = -1;

            int typePiece = plateau[ligneCaseAVerifier][colonneCaseAVerfier];

            if(typePiece%VariablesGlobales.codeDame == 0){
                boolean estBloqueTouteDirection = true;
                for(int nombreDiagonale = 0; nombreDiagonale < 4; nombreDiagonale ++){
                    int ligne = ligneCaseAVerifier + sensY;
                    int colonne = colonneCaseAVerfier + sensX;
                    boolean dansDomaineLigne =  (0 <= ligne) && (ligne <= 9);
                    boolean dansDomaineColonne = (0 <= colonne) && (colonne <= 9);

                    if(dansDomaineLigne && dansDomaineColonne){
                        boolean estBloqueSurCetteDirection = (plateau[ligne][colonne] != VariablesGlobales.codeCaseVide);
                        estBloqueTouteDirection = estBloqueTouteDirection && estBloqueSurCetteDirection;
                    }

                    if(nombreDiagonale%2 == 0) sensY = sensY * -1;
                    else sensX = sensX * -1;
                }
                return estBloqueTouteDirection;
            }
            else if(typePiece == VariablesGlobales.codePionNoir || typePiece == VariablesGlobales.codePionBlanc){
                boolean estBloqueDroit = true;
                boolean estBloqueGauche = true;

                int l_D = ligneCaseAVerifier + 1;
                int c_D = colonneCaseAVerfier + 1;

                int l_G = ligneCaseAVerifier + 1;
                int c_G = colonneCaseAVerfier - 1 ;

                if(typePiece == VariablesGlobales.codePionBlanc) {
                    l_D = ligneCaseAVerifier - 1;
                    l_G = ligneCaseAVerifier - 1;
                }

                if(0 <= l_D && l_D <= 9 && 0 <= c_D && c_D <= 9){
                    estBloqueDroit = (plateau[l_D][c_D] != VariablesGlobales.codeCaseVide);
                }
                if(0 <= l_G && l_G <= 9 && 0 <= c_G && c_G <= 9){
                    estBloqueGauche = (plateau[l_G][c_G] != VariablesGlobales.codeCaseVide);
                }

                return (estBloqueDroit && estBloqueGauche);
            }
        }

        return false;
    }
}

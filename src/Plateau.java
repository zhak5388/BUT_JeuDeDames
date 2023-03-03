public class Plateau {

    public static int[][] creationRemplissagePlateau() {

        int[][] plateau;
        plateau = new int[10][10];
        for (int ligne = 0; ligne < plateau.length; ligne++) {
            for (int colonne = 0; colonne < plateau[ligne].length; colonne++) {
                if ((ligne + colonne) % 2 == 0) {
                    plateau[ligne][colonne] = 13;
                } else {
                    if (ligne < 4) {
                        plateau[ligne][colonne] = 03;
                    } else if (ligne < 6) {
                        plateau[ligne][colonne] = 11;
                    } else {
                        plateau[ligne][colonne] = 05;
                    }
                }
            }
        }
        return plateau;
    }


    public static void afficherDamier(int[][] plateau) {
        //String couleurPiecePrise = "\033[33m"; //Jaune
        String couleurPiecePrise = "\033[31m"; //Rouge
        System.out.println("       1     2     3     4     5");
        for (int ligne = 0; ligne < plateau.length; ligne++) {

            if(ligne == 0) System.out.print("   ");
            else if (ligne == 1) System.out.print(" 6 ");
            else if (ligne == 2) System.out.print("   ");
            else if (ligne == 3) System.out.print("16 ");
            else if (ligne == 4) System.out.print("   ");
            else if (ligne == 5) System.out.print("26 ");
            else if (ligne == 6) System.out.print("   ");
            else if (ligne == 7) System.out.print("36 ");
            else if (ligne == 8) System.out.print("   ");
            else System.out.print("46 ");


            for (int colonne = 0; colonne < plateau[ligne].length; colonne++) {
                String fermuture = "\033[0m";
                String couleurFond = ((ligne + colonne) % 2 == 0) ? "\033[47m" : "\033[40m";
                if (plateau[ligne][colonne] == 13) {
                    System.out.print(couleurFond + "   ");
                } else if (plateau[ligne][colonne] == 11) {
                    System.out.print(couleurFond + "   ");
                } else if (plateau[ligne][colonne] == 05) {
                    System.out.print(couleurFond +" b " );
                } else if (plateau[ligne][colonne] == 03) {
                    System.out.print(couleurFond +" n " );
                } else if (plateau[ligne][colonne] == 10) {
                    System.out.print( couleurFond +" B " );
                } else  if (plateau[ligne][colonne] == 06){
                    System.out.print(couleurFond +" N " );
                } else if (plateau[ligne][colonne] == VariablesGlobales.codePionNoir * VariablesGlobales.codePiecePrise) {
                    System.out.print(couleurFond + couleurPiecePrise + " n " + fermuture );
                } else if (plateau[ligne][colonne] == VariablesGlobales.codePionBlanc * VariablesGlobales.codePiecePrise) {
                    System.out.print(couleurFond + couleurPiecePrise + " b " + fermuture);
                } else if (plateau[ligne][colonne] == VariablesGlobales.codeDameNoire * VariablesGlobales.codePiecePrise) {
                    System.out.print(couleurFond + couleurPiecePrise + " N " + fermuture);
                } else if (plateau[ligne][colonne] == VariablesGlobales.codeDameBlanche * VariablesGlobales.codePiecePrise) {
                    System.out.print(couleurFond + couleurPiecePrise + " B " + fermuture);
                }
                //System.out.print(" 6 ");
            }
            //System.out.println("\033[0m");

            System.out.print("\033[0m");
            if(ligne == 0) System.out.println(" 5");
            else if (ligne == 1) System.out.println();
            else if (ligne == 2) System.out.println(" 15");
            else if (ligne == 3) System.out.println();
            else if (ligne == 4) System.out.println(" 25");
            else if (ligne == 5) System.out.println();
            else if (ligne == 6) System.out.println(" 35");
            else if (ligne == 7) System.out.println();
            else if (ligne == 8) System.out.println(" 45");
            else System.out.println();
        }
        System.out.println("   46    47    48    49    50");
    }

    public static void afficherDamierContour(int[][] plateau) {

        System.out.println("       1     2     3     4     5");
        afficherDamier(plateau);
        System.out.println("   46    47    48    49    50");
    }

}
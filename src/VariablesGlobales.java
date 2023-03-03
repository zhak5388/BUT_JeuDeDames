public class VariablesGlobales {
    public static int codePieceNoire = 3;
    public static int codePieceBlanche = 5;

    public static int codeJoueurUn = codePieceBlanche;

    public static int codeJoueurDeux = codePieceNoire;
    public static int codeDame = 2;

    public static int codePionBlanc = codePieceBlanche;
    public static int codePionNoir = codePieceNoire;
    public static int codeDameBlanche = codeDame * codePieceBlanche;
    public static int codeDameNoire = codeDame * codePieceNoire;
    public static int codeCaseVide = 11;
    public static int codePiecePrise = 7;
    public static int codeCaseInterdite = 13;


    public static int codeErreurCaseDepartVide = -1;
    public static String messageErreurCaseDepartVide = "La case de départ est vide";
    public static int codeErreurCaseArriveeNonVide = -2;
    public static String messageErreurCaseArriveeNonVide = "La case d'arrivée n'est pas vide";
    public static int codeErreurPieceAppartenantAdversaire = -3;
    public static String messageErreurPieceAppartenantAdversaire = "La pièce selectionnée appartient à l'adversaire";
    public static int codeErreurMouvementNonDiagonal = -4;
    public static String messageErreurMouvementNonDiagonal = "Ce mouvement est interdit";
    public static int codeErreurMouvementPionImpossible = -5;
    public static String messageMouvementPionImpossible = "Ce mouvement de pion n'est pas possible";
    public static int codeErreurMouvementDameImpossible = -6;
    public static String messageMouvementDameImpossible = "Ce mouvement de dame n'est pas possible";
    public static int codeMouvementPionAvecPrise = 1;
    public static int codeMouvementPionSansPrise = 2;
    public static int codeMouvementDameAvecPrise = 3;
    public static int codeMouvementDameSansPrise = 4;

    public static String messageSaisieCaseDepart = "Saisissez votre case de départ : ";
    public static String messageSaisieCaseArrivee = "Saisissez votre case d'arrivée : ";
    public static String messageReSaisieCaseDepart = "Resaisissez votre case de départ : ";
    public static String messageReSaisieCaseArrivee = "Resaisissez votre case d'arrivée : ";
    public static String reglement = "1. La saisie des cases de départ et d'arrivée se fait en notation Manoury (cases entre 1 et 50)" +
            "\n 2. Les déplacements simples des pions se font" +
            "\n - pour les pions blancs : vers le haut en diagonale" +
            "\n - pour les pions noirs : vers le bas en diagonale" +
            "\n 3. Les déplacements simples des dames se font" +
            "\n - vers le haut ou le bas en diagonale" +
            "\n - NB : Les déplacements long de la dame sont autorisés" +
            "\n 4. Les déplacements avec prises se font dans les mêmes directions" +
            "\n - NB : Vous ne pouvez manger qu'un pion adverse à la fois" +
            "\n 5. Si une prise est possible, vous devez la priviliégier à un déplacement simple" +
            "\n 6. Si 2 pièces permettent de faire une prise, vous devez jouer celle permettant de faire la prise majoritare" +
            "\n - NB : Si plusieurs pièces permettent de faire une prise majoritaire, vous pouvez jouer celle que vous souhaitez" +
            "\n 7. Si une rafle a été entamée, vous devez la poursuivre jusqu'au bout";

    public static int[][] plateauDemoPriseMajo(){
        int[][] plateauDemo1 = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,11,13,11,13,11,13,11,13,11},
                /*1*/{11,13,06,13,03,13,11,13,03,13},
                /*2*/{13,11,13,11,13,11,13,11,13,11},
                /*3*/{11,13,03,13,11,13,05,13,11,13},
                /*4*/{13,11,13,11,13,11,13,11,13,11},
                /*5*/{11,13,03,13,11,13,11,13,11,13},
                /*6*/{13,05,13,11,13,11,13,11,13,11},
                /*7*/{11,13,11,13,11,13,11,13,11,13},
                /*8*/{13,11,13,11,13,11,13,11,13,03},
                /*9*/{11,13,11,13,11,13,10,13,11,13}
        };
        return plateauDemo1;
    }

    public static int[][] plateauDemoParalysie(){
        int[][] plateauDemoParalysie = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,11,13,11,13,11,13,11,13,03},
                /*1*/{11,13,11,13,11,13,11,13,05,13},
                /*2*/{13,11,13,11,13,11,13,11,13,11},
                /*3*/{11,13,11,13,11,13,11,13,05,13},
                /*4*/{13,11,13,11,13,11,13,11,13,11},
                /*5*/{11,13,11,13,11,13,11,13,11,13},
                /*6*/{13,11,13,11,13,11,13,11,13,11},
                /*7*/{11,13,05,13,11,13,11,13,11,13},
                /*8*/{13,10,13,11,13,11,13,11,13,11},
                /*9*/{06,13,11,13,11,13,11,13,11,13}
        };
        return plateauDemoParalysie;
    }


}

import java.util.Scanner;


public class Menu {

    public static void menu() {
        //System.out.println("le joueur 1 = blanc et 2 = noir");
        System.out.println("Bonjour! Bienvenue sur le Jeu de Dames Internationales");

        String menu = "Que souhaitez-vous faire ? \n 1 : Lire le réglement \n 2 : Commencer une nouvelle partie \n 3 : Lancer la démo prise majoritaire \n 4 : Lancer la démo victoire par paralysie \n 5 : Quitter \n Tapez 1, 2, 3, 4 ou 5 selon votre choix : ";
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.print(menu);
            choix = scanner.nextInt();
            System.out.println();

            switch (choix) {
                case 1:
                    System.out.println(VariablesGlobales.reglement);
                    break;
                case 2:
                    Partie.lancerPartie(Plateau.creationRemplissagePlateau(), VariablesGlobales.codeJoueurUn);
                    break;
                case 3:
                    Partie.lancerPartie(VariablesGlobales.plateauDemoPriseMajo(), 05);
                    break;
                case 4:
                    Partie.lancerPartie(VariablesGlobales.plateauDemoParalysie(), 05);
                    break;
                case 5:
                    System.out.println("Au revoir !");
            }
        } while (choix != 5);
    }

}
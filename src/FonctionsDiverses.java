import java.util.ArrayList;

public class FonctionsDiverses {
    public static int valeurAbsolue(int valeur){
        if(valeur < 0) return -valeur;
        else return valeur;
    }

    //Fonction pour faciliter l'ecriture des tests.
    public static ArrayList<ArrayList<Integer>> constructeurListePourTestPrisePossible(int[] tableau){
        ArrayList<ArrayList<Integer>> listeDesPrises = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < tableau.length; i=i+2){
            ArrayList<Integer > coupleNumeroCasePriseEtCaseArrivee = new ArrayList<Integer>();
            coupleNumeroCasePriseEtCaseArrivee.add(tableau[i]);
            coupleNumeroCasePriseEtCaseArrivee.add(tableau[i+1]);
            listeDesPrises.add(coupleNumeroCasePriseEtCaseArrivee);
        }
        return listeDesPrises;
    }

    public static ArrayList<Integer> constructeurListeCheminPourTest(int[] tableau){
        ArrayList<Integer> chemin = new ArrayList<Integer>();
        for(int i = 0; i < tableau.length; i++){
            chemin.add(tableau[i]);
        }
        return chemin;
    }
}

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PriseMajoritaireMethodesTest {

    @Test
    public final void cheminsPriseMajoritaireTest(){
        int[][] plateauPriseMajoritaire = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,06,13,11,13,11,13,11,13,11},
                /*1*/{11,13,11,13,11,13,11,13,03,13},
                /*2*/{13,05,13,05,13,11,13,11,13,11},
                /*3*/{11,13,11,13,11,13,11,13,03,13},
                /*4*/{13,05,13,11,13,11,13,11,13,11},
                /*5*/{05,13,11,13,11,13,11,13,11,13},
                /*6*/{13,05,13,05,13,03,13,03,13,11},
                /*7*/{03,13,11,13,11,13,11,13,11,13},
                /*8*/{13,11,13,10,13,11,13,03,13,11},
                /*9*/{11,13,11,13,05,13,11,13,11,13}
        };

        ArrayList<ArrayList<Integer>> aucunCheminPossible = new ArrayList<ArrayList<Integer>>();
        assertEquals(aucunCheminPossible, PriseMajoritaireMethodes.cheminsPriseMajoritaire(plateauPriseMajoritaire, 23), "Pion blanc, cas sans prise possible");
        assertEquals(aucunCheminPossible, PriseMajoritaireMethodes.cheminsPriseMajoritaire(plateauPriseMajoritaire, 9), "Case vide");
        assertEquals(aucunCheminPossible, PriseMajoritaireMethodes.cheminsPriseMajoritaire(plateauPriseMajoritaire, 8), "Case interdite");

        int[] priseMajoritaireDebut70 = {70,61,52,41,30,21,12,23,34};
        ArrayList<ArrayList<Integer>> cheminPriseDebut70 = new ArrayList<ArrayList<Integer>>();
        cheminPriseDebut70.add(FonctionsDiverses.constructeurListeCheminPourTest(priseMajoritaireDebut70));
        assertEquals(cheminPriseDebut70, PriseMajoritaireMethodes.cheminsPriseMajoritaire(plateauPriseMajoritaire, 70), "Cas pion noir, 1 seule prise majoritaire possible");

        ArrayList<ArrayList<Integer>> cheminPriseDebut83 = new ArrayList<ArrayList<Integer>>();
        int[] priseMajoritaireDebut83Possibilite1 = {83,65,56,67,78,87,96};
        int[] priseMajoritaireDebut83Possibilite2 = {83,65,56,38,29,18,7};
        int[] priseMajoritaireDebut83Possibilite3 = {83,65,47,38,29,18,7};
        cheminPriseDebut83.add(FonctionsDiverses.constructeurListeCheminPourTest(priseMajoritaireDebut83Possibilite1));
        cheminPriseDebut83.add(FonctionsDiverses.constructeurListeCheminPourTest(priseMajoritaireDebut83Possibilite2));
        cheminPriseDebut83.add(FonctionsDiverses.constructeurListeCheminPourTest(priseMajoritaireDebut83Possibilite3));
        assertEquals(cheminPriseDebut83, PriseMajoritaireMethodes.cheminsPriseMajoritaire(plateauPriseMajoritaire, 83), "Cas Dame Blanche, 3 prises majoritaires possibles");

        ArrayList<ArrayList<Integer>> cheminPriseDebut01 = new ArrayList<ArrayList<Integer>>();
        int[] priseMajoritaireDebut01Possibilite1 = {01,23,45,63,72};
        int[] priseMajoritaireDebut01Possibilite2 = {01,23,45,63,81};
        int[] priseMajoritaireDebut01Possibilite3 = {01,23,45,63,90};
        cheminPriseDebut01.add(FonctionsDiverses.constructeurListeCheminPourTest(priseMajoritaireDebut01Possibilite1));
        cheminPriseDebut01.add(FonctionsDiverses.constructeurListeCheminPourTest(priseMajoritaireDebut01Possibilite2));
        cheminPriseDebut01.add(FonctionsDiverses.constructeurListeCheminPourTest(priseMajoritaireDebut01Possibilite3));
        assertEquals(cheminPriseDebut01, PriseMajoritaireMethodes.cheminsPriseMajoritaire(plateauPriseMajoritaire, 01), "Cas Dame Noire, 1 prise possible avec 3 cases d'arrivées différentes");


        int[][] plateauCasParticulierPassageSurMemeCase= {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,11,13,05,13,11,13,11,13,11},
                /*1*/{11,13,11,13,03,13,06,13,11,13},
                /*2*/{13,11,13,11,13,11,13,11,13,11},
                /*3*/{11,13,11,13,03,13,06,13,11,13},
                /*4*/{13,11,13,11,13,11,13,11,13,11},
                /*5*/{11,13,11,13,03,13,03,13,11,13},
                /*6*/{13,11,13,11,13,11,13,11,13,11},
                /*7*/{11,13,11,13,11,13,11,13,11,13},
                /*8*/{13,11,13,11,13,11,13,11,13,11},
                /*9*/{11,13,11,13,11,13,11,13,11,13}
        };
        ArrayList<ArrayList<Integer>> casParticulierPassageSurMemeCase = new ArrayList<>();
        ArrayList<Integer> casParticulierPassageSurMemeCaseChemin1 = new ArrayList<Integer>(Arrays.asList(3,14,25,36,47,56,65,54,43,34,25,16,7));
        ArrayList<Integer> casParticulierPassageSurMemeCaseChemin2 = new ArrayList<Integer>(Arrays.asList(3,14,25,34,43,54,65,56,47,36,25,16,7));
        casParticulierPassageSurMemeCase.add(casParticulierPassageSurMemeCaseChemin1);
        casParticulierPassageSurMemeCase.add(casParticulierPassageSurMemeCaseChemin2);
        assertEquals(casParticulierPassageSurMemeCase,PriseMajoritaireMethodes.cheminsPriseMajoritaire(plateauCasParticulierPassageSurMemeCase,3));

        int[][] plateauCasRetourCaseDepart = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,11,13,11,13,11,13,11,13,11},
                /*1*/{11,13,11,13,11,13,11,13,11,13},
                /*2*/{13,11,13,11,13,11,13,11,13,11},
                /*3*/{11,13,11,13,11,13,11,13,11,13},
                /*4*/{13,03,13,03,13,11,13,11,13,11},
                /*5*/{05,13,11,13,11,13,11,13,11,13},
                /*6*/{13,03,13,03,13,11,13,11,13,11},
                /*7*/{11,13,11,13,11,13,11,13,11,13},
                /*8*/{13,11,13,11,13,11,13,11,13,11},
                /*9*/{11,13,11,13,11,13,11,13,11,13}
        };
        ArrayList<ArrayList<Integer>> casRetourCaseDepart = new ArrayList<>();
        ArrayList<Integer> casRetourCaseDepartChemin1 = new ArrayList<Integer>(Arrays.asList(50, 61, 72, 63, 54, 43, 32, 41, 50));
        ArrayList<Integer> casRetourCaseDepartChemin2 = new ArrayList<Integer>(Arrays.asList(50, 41, 32, 43, 54, 63, 72, 61, 50));
        casRetourCaseDepart.add(casRetourCaseDepartChemin1);
        casRetourCaseDepart.add(casRetourCaseDepartChemin2);
        assertEquals(casRetourCaseDepart,PriseMajoritaireMethodes.cheminsPriseMajoritaire(plateauCasRetourCaseDepart,50), "Cas particulier avec retour case depart");
    }

    @Test
    public final void listeDesPrisesCumuleesTest(){

        int[][] plateauVide = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,05,13,11,13,11,13,11,13,11},
                /*1*/{11,13,03,13,11,13,11,13,11,13},
                /*2*/{13,11,13,11,13,11,13,11,13,11},
                /*3*/{11,13,11,13,03,13,11,13,11,13},
                /*4*/{13,11,13,11,13,11,13,11,13,11},
                /*5*/{11,13,11,13,03,13,03,13,11,13},
                /*6*/{13,11,13,11,13,11,13,11,13,11},
                /*7*/{11,13,11,13,11,13,11,13,06,13},
                /*8*/{13,11,13,11,13,11,13,11,13,11},
                /*9*/{11,13,11,13,11,13,11,13,11,13}
        };
        ArrayList<ArrayList<Integer>> arbreDesPrises = new ArrayList<>();
        PriseMajoritaireMethodes.ajoutArbreDesPrises(arbreDesPrises,1,0,-1);
        PriseMajoritaireMethodes.ajoutArbreDesPrises(arbreDesPrises,23,0,12);
        PriseMajoritaireMethodes.ajoutArbreDesPrises(arbreDesPrises,45,1,34);
        PriseMajoritaireMethodes.ajoutArbreDesPrises(arbreDesPrises,67,2,56);
        PriseMajoritaireMethodes.ajoutArbreDesPrises(arbreDesPrises,63,2,54);
        PriseMajoritaireMethodes.ajoutArbreDesPrises(arbreDesPrises,89,3,78);

        ArrayList<Integer> priseEnIndice0 = new ArrayList<Integer>();
        ArrayList<Integer> priseEnIndice1 = new ArrayList<Integer>(Arrays.asList(12));
        ArrayList<Integer> priseEnIndice2 = new ArrayList<Integer>(Arrays.asList(34,12));
        ArrayList<Integer> priseEnIndice3 = new ArrayList<Integer>(Arrays.asList(56,34,12));
        ArrayList<Integer> priseEnIndice4 = new ArrayList<Integer>(Arrays.asList(54,34,12));
        ArrayList<Integer> priseEnIndice5 = new ArrayList<Integer>(Arrays.asList(78,56,34,12));
        assertEquals(priseEnIndice0, PriseMajoritaireMethodes.listeDesPrisesCumulees(arbreDesPrises,0),"Cas en indice 0");
        assertEquals(priseEnIndice1, PriseMajoritaireMethodes.listeDesPrisesCumulees(arbreDesPrises,1),"Cas en indice 1");
        assertEquals(priseEnIndice2, PriseMajoritaireMethodes.listeDesPrisesCumulees(arbreDesPrises,2),"Cas en indice 2");
        assertEquals(priseEnIndice3, PriseMajoritaireMethodes.listeDesPrisesCumulees(arbreDesPrises,3),"Cas en indice 3 et a un voisin");
        assertEquals(priseEnIndice4, PriseMajoritaireMethodes.listeDesPrisesCumulees(arbreDesPrises,4),"Cas en indice 4 et a un voisin");
        assertEquals(priseEnIndice5, PriseMajoritaireMethodes.listeDesPrisesCumulees(arbreDesPrises,5), "Cas en indice 5");
    }
    @Test
    public final void cheminsDesPrisesTest(){
        int[][] plateauCasClasiqueDame = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,11,13,11,13,11,13,11,13,11},
                /*1*/{11,13,11,13,11,13,11,13,03,13},
                /*2*/{13,11,13,11,13,11,13,11,13,11},
                /*3*/{11,13,11,13,06,13,11,13,06,13},
                /*4*/{13,05,13,05,13,11,13,10,13,11},
                /*5*/{11,13,11,13,11,13,11,13,11,13},
                /*6*/{13,11,13,11,13,11,13,11,13,11},
                /*7*/{11,13,11,13,11,13,11,13,11,13},
                /*8*/{13,11,13,11,13,05,13,11,13,11},
                /*9*/{11,13,11,13,11,13,11,13,11,13}
        };
        ArrayList<ArrayList<Integer>> casUnSeulCheminPossible = new ArrayList<>();
        ArrayList<Integer> casUnSeulCheminPossibleChemin = new ArrayList<Integer>(Arrays.asList(47, 38, 29,18,7));
        casUnSeulCheminPossible.add(casUnSeulCheminPossibleChemin);
        assertEquals(casUnSeulCheminPossible, PriseMajoritaireMethodes.cheminsDesPrises(plateauCasClasiqueDame,47), "Dame Blanche 1 seul chemin possible");

        ArrayList<ArrayList<Integer>> casPlusieursCheminsPossible = new ArrayList<>();
        ArrayList<Integer> casPlusieursCheminsPossibleChemin1 = new ArrayList<Integer>(Arrays.asList(34, 43, 61));
        ArrayList<Integer> casPlusieursCheminsPossibleChemin2 = new ArrayList<Integer>(Arrays.asList(34, 43, 70));
        ArrayList<Integer> casPlusieursCheminsPossibleChemin3 = new ArrayList<Integer>(Arrays.asList(34, 43, 52, 85, 96));
        ArrayList<Integer> casPlusieursCheminsPossibleChemin4 = new ArrayList<Integer>(Arrays.asList(34, 43, 52, 41, 30));
        casPlusieursCheminsPossible.add(casPlusieursCheminsPossibleChemin1);
        casPlusieursCheminsPossible.add(casPlusieursCheminsPossibleChemin2);
        casPlusieursCheminsPossible.add(casPlusieursCheminsPossibleChemin3);
        casPlusieursCheminsPossible.add(casPlusieursCheminsPossibleChemin4);
        assertEquals(casPlusieursCheminsPossible,PriseMajoritaireMethodes.cheminsDesPrises(plateauCasClasiqueDame,34),"Dame Noire, cas avec plusieurs chemins possibles");

        int[][] plateauCasPion = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,11,13,11,13,11,13,11,13,11},
                /*1*/{11,13,10,13,11,13,11,13,11,13},
                /*2*/{13,11,13,03,13,11,13,11,13,11},
                /*3*/{11,13,11,13,11,13,11,13,11,13},
                /*4*/{13,11,13,11,13,11,13,11,13,11},
                /*5*/{11,13,11,13,11,13,03,13,11,13},
                /*6*/{13,11,13,11,13,11,13,11,13,11},
                /*7*/{11,13,03,13,03,13,11,13,11,13},
                /*8*/{13,11,13,05,13,11,13,11,13,11},
                /*9*/{11,13,11,13,11,13,11,13,11,13}
        };

        ArrayList<ArrayList<Integer>> casPionUnSeulChemin = new ArrayList<>();
        ArrayList<Integer> casPionUnSeulCheminChemin1 = new ArrayList<Integer>(Arrays.asList(23,12,1));
        casPionUnSeulChemin.add(casPionUnSeulCheminChemin1);
        assertEquals(casPionUnSeulChemin,PriseMajoritaireMethodes.cheminsDesPrises(plateauCasPion,23));

        ArrayList<ArrayList<Integer>> casPionDeuxChemins = new ArrayList<>();
        ArrayList<Integer> casPionDeuxCheminsChemin1 = new ArrayList<Integer>(Arrays.asList(83,72,61));
        ArrayList<Integer> casPionDeuxCheminsChemin2 = new ArrayList<Integer>(Arrays.asList(83,74,65,56,47));
        casPionDeuxChemins.add(casPionDeuxCheminsChemin1);
        casPionDeuxChemins.add(casPionDeuxCheminsChemin2);
        assertEquals(casPionDeuxChemins,PriseMajoritaireMethodes.cheminsDesPrises(plateauCasPion,83));

        int[][] plateauCasRetourCaseDepart = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,11,13,11,13,11,13,11,13,11},
                /*1*/{11,13,11,13,11,13,11,13,11,13},
                /*2*/{13,11,13,11,13,11,13,11,13,11},
                /*3*/{11,13,11,13,11,13,11,13,11,13},
                /*4*/{13,03,13,03,13,11,13,11,13,11},
                /*5*/{05,13,11,13,11,13,11,13,11,13},
                /*6*/{13,03,13,03,13,11,13,11,13,11},
                /*7*/{11,13,11,13,11,13,11,13,11,13},
                /*8*/{13,11,13,11,13,11,13,11,13,11},
                /*9*/{11,13,11,13,11,13,11,13,11,13}
        };
        ArrayList<ArrayList<Integer>> casRetourCaseDepart = new ArrayList<>();
        ArrayList<Integer> casRetourCaseDepartChemin1 = new ArrayList<Integer>(Arrays.asList(50, 61, 72, 63, 54, 43, 32, 41, 50));
        ArrayList<Integer> casRetourCaseDepartChemin2 = new ArrayList<Integer>(Arrays.asList(50, 41, 32, 43, 54, 63, 72, 61, 50));
        casRetourCaseDepart.add(casRetourCaseDepartChemin1);
        casRetourCaseDepart.add(casRetourCaseDepartChemin2);
        assertEquals(casRetourCaseDepart,PriseMajoritaireMethodes.cheminsDesPrises(plateauCasRetourCaseDepart,50), "Cas particulier avec retour case depart");

        int[][] plateauCasParticulierPassageSurMemeCase= {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,11,13,05,13,11,13,11,13,11},
                /*1*/{11,13,11,13,03,13,06,13,11,13},
                /*2*/{13,11,13,11,13,11,13,11,13,11},
                /*3*/{11,13,11,13,03,13,06,13,11,13},
                /*4*/{13,11,13,11,13,11,13,11,13,11},
                /*5*/{11,13,11,13,03,13,03,13,11,13},
                /*6*/{13,11,13,11,13,11,13,11,13,11},
                /*7*/{11,13,11,13,11,13,11,13,11,13},
                /*8*/{13,11,13,11,13,11,13,11,13,11},
                /*9*/{11,13,11,13,11,13,11,13,11,13}
        };
        ArrayList<ArrayList<Integer>> casParticulierPassageSurMemeCase = new ArrayList<>();
        ArrayList<Integer> casParticulierPassageSurMemeCaseChemin1 = new ArrayList<Integer>(Arrays.asList(3, 14, 25, 16, 7));
        ArrayList<Integer> casParticulierPassageSurMemeCaseChemin2 = new ArrayList<Integer>(Arrays.asList(3,14,25,36,47,56,65,54,43,34,25,16,7));
        ArrayList<Integer> casParticulierPassageSurMemeCaseChemin3 = new ArrayList<Integer>(Arrays.asList(3, 14, 25, 34, 43, 54, 65, 56, 47, 36, 25, 16, 7));
        casParticulierPassageSurMemeCase.add(casParticulierPassageSurMemeCaseChemin1);
        casParticulierPassageSurMemeCase.add(casParticulierPassageSurMemeCaseChemin2);
        casParticulierPassageSurMemeCase.add(casParticulierPassageSurMemeCaseChemin3);
        assertEquals(casParticulierPassageSurMemeCase,PriseMajoritaireMethodes.cheminsDesPrises(plateauCasParticulierPassageSurMemeCase,3));
    }
    @Test
    public final void enleverEtMarquePriseSurPlateauTest(){
        int[][] plateauNonMarque = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,11,13,11,13,11,13,11,13,11},
                /*1*/{11,13,11,13,11,13,11,13,11,13},
                /*2*/{13,10,13,05,13,05,13,05,13,11},
                /*3*/{11,13,11,13,11,13,11,13,11,13},
                /*4*/{13,05,13,11,13,11,13,05,13,11},
                /*5*/{11,13,11,13,11,13,11,13,11,13},
                /*6*/{13,05,13,11,13,11,13,05,13,11},
                /*7*/{03,13,11,13,11,13,11,13,11,13},
                /*8*/{13,11,13,11,13,11,13,10,13,11},
                /*9*/{11,13,11,13,11,13,11,13,11,13}
        };

        int[][] plateauAManipule = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,11,13,11,13,11,13,11,13,11},
                /*1*/{11,13,11,13,11,13,11,13,11,13},
                /*2*/{13,10,13,05,13,05,13,05,13,11},
                /*3*/{11,13,11,13,11,13,11,13,11,13},
                /*4*/{13,05,13,11,13,11,13,05,13,11},
                /*5*/{11,13,11,13,11,13,11,13,11,13},
                /*6*/{13,05,13,11,13,11,13,05,13,11},
                /*7*/{03,13,11,13,11,13,11,13,11,13},
                /*8*/{13,11,13,11,13,11,13,10,13,11},
                /*9*/{11,13,11,13,11,13,11,13,11,13}
        };

        int[][] plateauMarque = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,11,13,11,13,11,13,11,13,11},
                /*1*/{11,13,11,13,11,13,11,13,11,13},
                /*2*/{13,70,13,35,13,35,13,35,13,11},
                /*3*/{11,13,11,13,11,13,11,13,11,13},
                /*4*/{13,35,13,11,13,11,13,35,13,11},
                /*5*/{11,13,11,13,11,13,11,13,11,13},
                /*6*/{13,35,13,11,13,11,13,35,13,11},
                /*7*/{03,13,11,13,11,13,11,13,11,13},
                /*8*/{13,11,13,11,13,11,13,70,13,11},
                /*9*/{11,13,11,13,11,13,11,13,11,13}
        };

        ArrayList<Integer> listePrise = new ArrayList<Integer>(Arrays.asList(61,41,21,23,25,27,47,87,67));
        PriseMajoritaireMethodes.marquePriseSurPlateau(plateauAManipule,listePrise);
        assertArrayEquals(plateauMarque, plateauAManipule, "Cas classique, marque les prises");
        PriseMajoritaireMethodes.enleveMarquePriseSurPlateau(plateauAManipule, listePrise);
        assertArrayEquals(plateauNonMarque,plateauAManipule, "Cas classque, enleve les marques");

    }

    @Test
    public final void prisePossible(){
        int[][] plateau = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,05,13,05,13,11,13,03,13,11},
                /*1*/{11,13,03,13,11,13,05,13,05,13},
                /*2*/{13,03,13,03,13,11,13,11,13,11},
                /*3*/{11,13,05,13,11,13,03,13,03,13},
                /*4*/{13,03,13,03,13,11,13,05,13,11},
                /*5*/{11,13,11,13,11,13,03,13,05,13},
                /*6*/{13,11,13,11,13,11,13,11,13,11},
                /*7*/{11,13,03,13,11,13,11,13,11,13},
                /*8*/{13,05,13,11,13,05,13,10,13,11},
                /*9*/{11,13,11,13,11,13,11,13,03,13}
        };
        int[] quatrePrises = {43,54,23,14,21,10,41,50};
        assertEquals(FonctionsDiverses.constructeurListePourTestPrisePossible(quatrePrises),PriseMajoritaireMethodes.prisePossible(plateau,32), "Pion blanc. Cas avec 4 prises possibles.");
        int[] troisPrises = {38,29,36,25,56,65};
        assertEquals(FonctionsDiverses.constructeurListePourTestPrisePossible(troisPrises),PriseMajoritaireMethodes.prisePossible(plateau,47),"Pion noir. Cas de trois prises avec un pion noir dans une des diagonales");
        int[] deuxPrises = {18,29,16,25};
        assertEquals(FonctionsDiverses.constructeurListePourTestPrisePossible(deuxPrises),PriseMajoritaireMethodes.prisePossible(plateau,7),"Pion blanc. Cas deux prises");
        int[] unePrise = {87,76};
        assertEquals(FonctionsDiverses.constructeurListePourTestPrisePossible(unePrise),PriseMajoritaireMethodes.prisePossible(plateau,98), "Pion noir. Cas une prise de dame");
        int[] unePriseBord = {81,90};
        assertEquals(FonctionsDiverses.constructeurListePourTestPrisePossible(unePriseBord),PriseMajoritaireMethodes.prisePossible(plateau,72), "Attaquant noir. Cas une prise avec arrivé au coin");

        int[] aucunePrise = {};
        assertEquals(FonctionsDiverses.constructeurListePourTestPrisePossible(aucunePrise), PriseMajoritaireMethodes.prisePossible(plateau,85),"Pion blanc,  aucune prise : cases aux alentours vides");
        assertEquals(FonctionsDiverses.constructeurListePourTestPrisePossible(aucunePrise), PriseMajoritaireMethodes.prisePossible(plateau,12),"Pion noir, aucune prise : cases aux alentours occupees");
        assertEquals(FonctionsDiverses.constructeurListePourTestPrisePossible(aucunePrise), PriseMajoritaireMethodes.prisePossible(plateau,43),"Pion noir,  aucune prise : mixte de case vide et occupée");
        assertEquals(FonctionsDiverses.constructeurListePourTestPrisePossible(aucunePrise), PriseMajoritaireMethodes.prisePossible(plateau,1),"Cas aucune prise : case vide");
        assertEquals(FonctionsDiverses.constructeurListePourTestPrisePossible(aucunePrise), PriseMajoritaireMethodes.prisePossible(plateau,15),"Cas aucune prise : case interdite");

        int[][] plateauDame = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,06,13,10,13,11,13,11,13,11},
                /*1*/{11,13,11,13,11,13,11,13,11,13},
                /*2*/{13,03,13,11,13,11,13,11,13,11},
                /*3*/{11,13,11,13,11,13,03,13,11,13},
                /*4*/{13,11,13,11,13,11,13,11,13,11},
                /*5*/{11,13,11,13,10,13,11,13,11,13},
                /*6*/{13,11,13,11,13,03,13,11,13,06},
                /*7*/{11,13,11,13,11,13,11,13,10,13},
                /*8*/{13,03,13,11,13,11,13,11,13,05},
                /*9*/{11,13,11,13,11,13,11,13,11,13}
        };

        int[] quatrePrisesDame = {65,76,65,87,65,98,36,27,36,18,36,9,21,10,81,90};
        assertEquals(FonctionsDiverses.constructeurListePourTestPrisePossible(quatrePrisesDame),PriseMajoritaireMethodes.prisePossible(plateauDame,54),"Dame Blanche, 4 prises dont une au bord");

        int[] deuxPrisesDame = {36,47,36,58,21,30};
        assertEquals(FonctionsDiverses.constructeurListePourTestPrisePossible(deuxPrisesDame),PriseMajoritaireMethodes.prisePossible(plateauDame,3), "Dame Blanche, 2 prises dont une avec obstacle");

        int[] unePriseDame = {78,87,78,96};
        assertEquals(FonctionsDiverses.constructeurListePourTestPrisePossible(unePriseDame),PriseMajoritaireMethodes.prisePossible(plateauDame,69), "Dame Noire, 1 prise");

        assertEquals(FonctionsDiverses.constructeurListePourTestPrisePossible(aucunePrise),PriseMajoritaireMethodes.prisePossible(plateauDame,01), "Dame Noire, aucune prise : case arrivée occupée");
        assertEquals(FonctionsDiverses.constructeurListePourTestPrisePossible(aucunePrise),PriseMajoritaireMethodes.prisePossible(plateauDame,78), "Dame Blanche, aucune prise : mixte de case vide et occupée");
    }
}
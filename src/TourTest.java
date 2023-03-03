import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
public class TourTest {

    @Test
    public final void listeDesDifferentsCheminsPriseMajoPossiblePourChaquePieceDuPlateauTest(){
        int[][] plateau3CheminsDeTaille1 = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,11,13,11,13,11,13,11,13,11},
                /*1*/{11,13,06,13,11,13,11,13,11,13},
                /*2*/{13,05,13,11,13,11,13,11,13,11},
                /*3*/{11,13,11,13,11,13,11,13,11,13},
                /*4*/{13,11,13,11,13,11,13,11,13,11},
                /*5*/{11,13,11,13,11,13,11,13,11,13},
                /*6*/{13,11,13,11,13,11,13,11,13,11},
                /*7*/{11,13,03,13,11,13,11,13,10,13},
                /*8*/{13,10,13,11,13,11,13,11,13,11},
                /*9*/{11,13,11,13,11,13,11,13,11,13}
        };

        ArrayList<Integer> taille1chemin1 = new ArrayList<Integer>(Arrays.asList(12, 78, 89));
        ArrayList<Integer> taille1chemin2 = new ArrayList<Integer>(Arrays.asList(12, 21, 30));
        ArrayList<Integer> taille1chemin3 = new ArrayList<Integer>(Arrays.asList(72, 81, 90));

        ArrayList<ArrayList<Integer>> cheminsEn12 = new ArrayList<>();
        cheminsEn12.add(taille1chemin1);
        cheminsEn12.add(taille1chemin2);

        ArrayList<ArrayList<Integer>> cheminsEn72 = new ArrayList<>();
        cheminsEn72.add(taille1chemin3);

        ArrayList<ArrayList<ArrayList<Integer>>> cheminPlateau3CheminsDeTaille1 = new ArrayList<>();
        cheminPlateau3CheminsDeTaille1.add(cheminsEn12);
        cheminPlateau3CheminsDeTaille1.add(cheminsEn72);

        assertEquals(cheminPlateau3CheminsDeTaille1,Tour.listeDesDifferentsCheminsPriseMajoPossiblePourChaquePieceDuPlateau(plateau3CheminsDeTaille1,03),"Cas il y a que des chemins de meme taille (1 prise)");

        int[][] plateau2CheminsDeTaille1EtCheminDeTaille2 = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,11,13,11,13,11,13,11,13,11},
                /*1*/{11,13,06,13,11,13,11,13,11,13},
                /*2*/{13,05,13,11,13,11,13,11,13,11},
                /*3*/{11,13,11,13,11,13,11,13,11,13},
                /*4*/{13,11,13,11,13,11,13,11,13,11},
                /*5*/{11,13,11,13,11,13,05,13,11,13},
                /*6*/{13,11,13,11,13,11,13,11,13,11},
                /*7*/{11,13,03,13,11,13,11,13,10,13},
                /*8*/{13,10,13,11,13,11,13,11,13,11},
                /*9*/{11,13,11,13,11,13,11,13,11,13}
        };

        ArrayList<Integer> taille2chemin1 = new ArrayList<Integer>(Arrays.asList(12, 56,67,78,89));

        ArrayList<ArrayList<Integer>> cheminsEn72Taille2 = new ArrayList<>();
        cheminsEn72Taille2.add(taille2chemin1);

        ArrayList<ArrayList<ArrayList<Integer>>> cheminPlateau1CheminsDeTaille2 = new ArrayList<>();
        cheminPlateau1CheminsDeTaille2.add(cheminsEn72Taille2);

        assertEquals(cheminPlateau1CheminsDeTaille2, Tour.listeDesDifferentsCheminsPriseMajoPossiblePourChaquePieceDuPlateau(plateau2CheminsDeTaille1EtCheminDeTaille2,03), "Cas ou il y a un chemin plus grand que les autres");

        int[][] plateauTest
                = { /* 0,  1 , 2,  3,  4,  5,  6,  7,  8,  9*/
                /*0*/{13, 11, 13, 11, 13, 11, 13, 11, 13, 11},
                /*1*/{11, 13, 11, 13, 11, 13, 11, 13, 11, 13},
                /*2*/{13, 11, 13, 11, 13, 11, 13, 06, 13, 11},
                /*3*/{11, 13, 11, 13, 11, 13, 11, 13, 11, 13},
                /*4*/{13, 11, 13, 03, 13, 03, 13, 03, 13, 11},
                /*5*/{11, 13, 11, 13, 05, 13, 11, 13, 11, 13},
                /*6*/{13, 11, 13, 11, 13, 11, 13, 11, 13, 11},
                /*7*/{11, 13, 11, 13, 11, 13, 11, 13, 11, 13},
                /*8*/{13, 03, 13, 06, 13, 10, 13, 11, 13, 11},
                /*9*/{10, 13, 11, 13, 11, 13, 10, 13, 11, 13}
        };

        ArrayList<Integer> liste1 = new ArrayList<Integer>(Arrays.asList(54, 45, 36, 47, 58));
        ArrayList<Integer> liste2 = new ArrayList<Integer>(Arrays.asList(54, 45, 36, 27, 18));
        ArrayList<Integer> liste3 = new ArrayList<Integer>(Arrays.asList(90, 81, 72, 83, 94));

        ArrayList<ArrayList<Integer>> liste1Niveau2 = new ArrayList<>();
        liste1Niveau2.add(liste1);
        liste1Niveau2.add(liste2);

        ArrayList<ArrayList<Integer>> liste2Niveau2 = new ArrayList<>();
        liste2Niveau2.add(liste3);

        ArrayList<ArrayList<ArrayList<Integer>>> listePriseMajorPion05Niveau3 = new ArrayList<>();
        listePriseMajorPion05Niveau3.add(liste1Niveau2);
        listePriseMajorPion05Niveau3.add(liste2Niveau2);

        assertEquals(listePriseMajorPion05Niveau3,Tour.listeDesDifferentsCheminsPriseMajoPossiblePourChaquePieceDuPlateau(plateauTest, 05), "Cas 3 chemins de meme taille 2 prises");
    }

    @Test
    public final void positionPiecePriseTest(){
        int[][] plateau= {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,11,13,11,13,11,13,11,13,11},
                /*1*/{11,13,05,13,05,13,11,13,11,13},
                /*2*/{13,11,13,03,13,11,13,11,13,11},
                /*3*/{11,13,11,13,10,13,03,13,11,13},
                /*4*/{13,11,13,11,13,11,13,11,13,11},
                /*5*/{11,13,11,13,11,13,11,13,11,13},
                /*6*/{13,05,13,10,13,11,13,11,13,11},
                /*7*/{11,13,06,13,11,13,11,13,11,13},
                /*8*/{13,05,13,05,13,03,13,11,13,11},
                /*9*/{11,13,11,13,11,13,11,13,11,13}
        };

        ArrayList<ArrayList<ArrayList<Integer>>> listeDesPrisesMajo = Tour.listeDesDifferentsCheminsPriseMajoPossiblePourChaquePieceDuPlateau(plateau,03);

        assertEquals(81,Tour.positionPiecePrise(72,90,listeDesPrisesMajo),"Dame noire, prise bas gauche, 1 seule case arrivée possible");
        assertEquals(83,Tour.positionPiecePrise(72,94,listeDesPrisesMajo), "Dame noire, prise bas droit, 1 seule case arrivée possible");
        assertEquals(63,Tour.positionPiecePrise(72,54,listeDesPrisesMajo), "Dame noire, prise haut droit, premiere case arrivée possible" );
        assertEquals(63,Tour.positionPiecePrise(72,45,listeDesPrisesMajo), "Dame noire, prise haut droit, deuxieme case arrivée possible");
        assertEquals(61,Tour.positionPiecePrise(72,50,listeDesPrisesMajo), "Dame noire, prise haut gauche, 1 seule case arrivée possible");

        assertEquals(14,Tour.positionPiecePrise(23,5,listeDesPrisesMajo), "Pion noir, prise haut droit" );
        assertEquals(12,Tour.positionPiecePrise(23,1,listeDesPrisesMajo), "Pion noir, prise haut gauche");
        assertEquals(34,Tour.positionPiecePrise(23,45,listeDesPrisesMajo), "Pion noir, prise bas droit");

        int[][] plateauTestListePiecePrise =
                { /* 0,  1 , 2,  3,  4,  5,  6,  7,  8,  9*/
                /*0*/{13, 11, 13, 11, 13, 11, 13, 11, 13, 11},
                /*1*/{11, 13, 11, 13, 11, 13, 11, 13, 11, 13},
                /*2*/{13, 03, 13, 11, 13, 11, 13, 06, 13, 11},
                /*3*/{11, 13, 11, 13, 11, 13, 11, 13, 11, 13},
                /*4*/{13, 11, 13, 03, 13, 03, 13, 03, 13, 11},
                /*5*/{11, 13, 11, 13, 05, 13, 11, 13, 11, 13},
                /*6*/{13, 11, 13, 11, 13, 11, 13, 11, 13, 11},
                /*7*/{11, 13, 11, 13, 11, 13, 11, 13, 11, 13},
                /*8*/{13, 03, 13, 06, 13, 10, 13, 11, 13, 11},
                /*9*/{10, 13, 11, 13, 11, 13, 10, 13, 11, 13}
        };

        int[][] plateauTestMouvementImpossible = {
                    /* 0,  1 , 2,  3,  4,  5,  6,  7,  8,  9*/
                /*0*/{13, 11, 13, 11, 13, 11, 13, 11, 13, 11},
                /*1*/{11, 13, 11, 13, 11, 13, 11, 13, 11, 13},
                /*2*/{13, 03, 13, 11, 13, 11, 13, 06, 13, 11},
                /*3*/{11, 13, 11, 13, 11, 13, 11, 13, 11, 13},
                /*4*/{13, 11, 13, 03, 13, 03, 13, 03, 13, 11},
                /*5*/{11, 13, 11, 13, 05, 13, 11, 13, 11, 13},
                /*6*/{13, 11, 13, 11, 13, 11, 13, 11, 13, 11},
                /*7*/{11, 13, 11, 13, 11, 13, 11, 13, 11, 13},
                /*8*/{13, 03, 13, 06, 13, 10, 13, 11, 13, 11},
                /*9*/{10, 13, 11, 13, 11, 13, 10, 13, 11, 13}
        };

        ArrayList<ArrayList<ArrayList<Integer>>> listePriseMajoJoueurBlanc = Tour.listeDesDifferentsCheminsPriseMajoPossiblePourChaquePieceDuPlateau(plateauTestListePiecePrise, 05);
        assertEquals(43, Tour.positionPiecePrise(54, 32, listePriseMajoJoueurBlanc), "pion blanc");

        ArrayList<ArrayList<ArrayList<Integer>>> listeTest = Tour.listeDesDifferentsCheminsPriseMajoPossiblePourChaquePieceDuPlateau(plateauTestMouvementImpossible, 05);
        assertEquals(45, Tour.positionPiecePrise(54, 36, listeTest), "Pion blanc prise");
        assertEquals(-1, Tour.positionPiecePrise(54, 18, listeTest), "deplacement impossible : manger 2 pieces");
        assertEquals(-1, Tour.positionPiecePrise(65, 56, listeTest), "deplacement impossible : case depart vide");
    }

    @Test
    public final void miseAJourPlateauDeplacementTest(){
        int[][] plateauAvant = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,11,13,11,13,11,13,11,13,11},
                /*1*/{11,13,11,13,11,13,11,13,11,13},
                /*2*/{13,11,13,06,13,11,13,11,13,11},
                /*3*/{11,13,11,13,11,13,11,13,11,13},
                /*4*/{13,11,13,11,13,11,13,11,13,11},
                /*5*/{11,13,11,13,11,13,11,13,11,13},
                /*6*/{13,11,13,11,13,11,13,11,13,11},
                /*7*/{11,13,11,13,11,13,11,13,11,13},
                /*8*/{13,11,13,11,13,11,13,11,13,11},
                /*9*/{11,13,11,13,11,13,11,13,11,13}
        };

        int[][] plateauApres = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,11,13,11,13,11,13,11,13,11},
                /*1*/{11,13,11,13,11,13,11,13,11,13},
                /*2*/{13,11,13,11,13,11,13,11,13,11},
                /*3*/{11,13,11,13,11,13,11,13,11,13},
                /*4*/{13,11,13,11,13,11,13,11,13,11},
                /*5*/{11,13,11,13,11,13,06,13,11,13},
                /*6*/{13,11,13,11,13,11,13,11,13,11},
                /*7*/{11,13,11,13,11,13,11,13,11,13},
                /*8*/{13,11,13,11,13,11,13,11,13,11},
                /*9*/{11,13,11,13,11,13,11,13,11,13}
        };

        Tour.miseAJourPlateauDeplacement(plateauAvant,23,56);
        assertArrayEquals(plateauApres,plateauAvant);
    }

    @Test
    public final void conversionTableauManouryTest(){
        assertEquals(1,Tour.conversionTableauManoury(1));
        assertEquals(2,Tour.conversionTableauManoury(3));
        assertEquals(3,Tour.conversionTableauManoury(5));
        assertEquals(5,Tour.conversionTableauManoury(9));
        assertEquals(6,Tour.conversionTableauManoury(10));
        assertEquals(7,Tour.conversionTableauManoury(12));
        assertEquals(9,Tour.conversionTableauManoury(16));
        assertEquals(10,Tour.conversionTableauManoury(18));
        assertEquals(17,Tour.conversionTableauManoury(32));
        assertEquals(24,Tour.conversionTableauManoury(47));
        assertEquals(50,Tour.conversionTableauManoury(98));

        assertEquals(27,Tour.conversionTableauManoury(52));
        assertEquals(28,Tour.conversionTableauManoury(54));
        assertEquals(30,Tour.conversionTableauManoury(58));
        assertEquals(31,Tour.conversionTableauManoury(61));
        assertEquals(32,Tour.conversionTableauManoury(63));
        assertEquals(35,Tour.conversionTableauManoury(69));
        assertEquals(36,Tour.conversionTableauManoury(70));

    }

    @Test
    public final void conversionMamouryTableauTest(){
        assertEquals(1,Tour.conversionManouryTableau(1));
        assertEquals(3,Tour.conversionManouryTableau(2));
        assertEquals(5,Tour.conversionManouryTableau(3));
        assertEquals(9,Tour.conversionManouryTableau(5));
        assertEquals(10,Tour.conversionManouryTableau(6));
        assertEquals(12,Tour.conversionManouryTableau(7));
        assertEquals(16,Tour.conversionManouryTableau(9));
        assertEquals(18,Tour.conversionManouryTableau(10));
        assertEquals(32,Tour.conversionManouryTableau(17));
        assertEquals(47,Tour.conversionManouryTableau(24));
        assertEquals(98,Tour.conversionManouryTableau(50));

        assertEquals(52,Tour.conversionManouryTableau(27));
        assertEquals(54,Tour.conversionManouryTableau(28));
        assertEquals(58,Tour.conversionManouryTableau(30));
        assertEquals(61,Tour.conversionManouryTableau(31));
        assertEquals(63,Tour.conversionManouryTableau(32));
        assertEquals(69,Tour.conversionManouryTableau(35));
        assertEquals(70,Tour.conversionManouryTableau(36));
    }
    @Test
    public final void listeCheminsCaseDepartChoisieTest(){

        int[][] plateauVide = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,03,13,11,13,11,13,11,13,11},
                /*1*/{11,13,05,13,05,13,11,13,11,13},
                /*2*/{13,11,13,11,13,11,13,11,13,11},
                /*3*/{11,13,05,13,11,13,11,13,11,13},
                /*4*/{13,11,13,11,13,11,13,11,13,11},
                /*5*/{06,13,11,13,11,13,11,13,11,13},
                /*6*/{13,03,13,05,13,11,13,05,13,11},
                /*7*/{11,13,11,13,11,13,11,13,11,13},
                /*8*/{13,11,13,05,13,05,13,05,13,11},
                /*9*/{11,13,11,13,11,13,03,13,11,13}
        };

        ArrayList<ArrayList<ArrayList<Integer>>> listePrisePlateau = new ArrayList<>();
        ArrayList<ArrayList<ArrayList<Integer>>> listePrisePlateauAttendu = new ArrayList<>();
        ArrayList<ArrayList<Integer>> listePrisePlateauChemin50 = new ArrayList<>();

        listePrisePlateau = Tour.listeDesDifferentsCheminsPriseMajoPossiblePourChaquePieceDuPlateau(plateauVide,03);

        ArrayList<Integer> liste50Un = new ArrayList<Integer>(Arrays.asList(50, 32, 23, 67, 78));
        ArrayList<Integer> liste50Deux = new ArrayList<Integer>(Arrays.asList(50, 32, 23, 67, 89));
        ArrayList<Integer> liste50Trois = new ArrayList<Integer>(Arrays.asList(50, 32, 23, 14, 5));
        listePrisePlateauChemin50.add(liste50Un);
        listePrisePlateauChemin50.add(liste50Deux);
        listePrisePlateauChemin50.add(liste50Trois);
        listePrisePlateauAttendu.add(listePrisePlateauChemin50);

        Tour.listeCheminsCaseDepartChoisie(50,listePrisePlateau);
        assertEquals(listePrisePlateauAttendu,listePrisePlateau);
    }

    @Test
    public final void legaliteMouvementTest(){
        int[][] plateau = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,11,13,11,13,11,13,11,13,11},
                /*1*/{11,13,03,13,11,13,11,13,11,13},
                /*2*/{13,11,13,11,13,05,13,10,13,11},
                /*3*/{11,13,11,13,11,13,03,13,11,13},
                /*4*/{13,11,13,11,13,10,13,05,13,11},
                /*5*/{11,13,11,13,11,13,11,13,11,13},
                /*6*/{13,11,13,11,13,11,13,11,13,11},
                /*7*/{11,13,11,13,11,13,05,13,11,13},
                /*8*/{13,11,13,05,13,03,13,11,13,11},
                /*9*/{11,13,11,13,11,13,11,13,11,13}
        };

        assertEquals(VariablesGlobales.codeErreurCaseDepartVide,Tour.legaliteMouvement(plateau,90,74,03), "Cas d'une selection d'une case de depart vide");
        assertEquals(VariablesGlobales.codeErreurCaseArriveeNonVide,Tour.legaliteMouvement(plateau,85,76,05), "Cas d'une selection d'une case d'arrivee non vide");
        assertEquals(VariablesGlobales.codeErreurPieceAppartenantAdversaire,Tour.legaliteMouvement(plateau,83,74,03), "Cas d'une selection piece adverse");
        assertEquals(VariablesGlobales.codeErreurMouvementNonDiagonal,Tour.legaliteMouvement(plateau,83,54,05), "Cas d'un mouvement non diagonal");



        /*Cas Pion*/

        assertEquals(VariablesGlobales.codeErreurMouvementPionImpossible,Tour.legaliteMouvement(plateau,83,94,05), "Pion blanc : Cas d'un mouvement simple interdit vers le bas droit");
        assertEquals(VariablesGlobales.codeErreurMouvementPionImpossible,Tour.legaliteMouvement(plateau,12,1,03), "Pion noir : Cas d'un mouvement simple interdit vers le haut gauche");

        assertEquals(VariablesGlobales.codeMouvementPionSansPrise,Tour.legaliteMouvement(plateau,83,74,05), "Pion blanc, cas d'un mouvement simple vers la droite");
        assertEquals(VariablesGlobales.codeMouvementPionSansPrise,Tour.legaliteMouvement(plateau,83,72,05), "Pion blanc, cas d'un mouvement simple vers la gauche");

        assertEquals(VariablesGlobales.codeMouvementPionSansPrise,Tour.legaliteMouvement(plateau,12,23,03), "Pion noir, cas d'un mouvement simple vers la droite");
        assertEquals(VariablesGlobales.codeMouvementPionSansPrise,Tour.legaliteMouvement(plateau,12,21,03), "Pion noir, cas d'un mouvement simple vers la gauche");

        assertEquals(VariablesGlobales.codeMouvementPionAvecPrise,Tour.legaliteMouvement(plateau,36,18,03), "Pion noir, cas d'une prise de dame vers le haut droit");
        assertEquals(VariablesGlobales.codeMouvementPionAvecPrise,Tour.legaliteMouvement(plateau,36,14,03), "Pion noir, cas d'une prise vers le haut gauche");
        assertEquals(VariablesGlobales.codeMouvementPionAvecPrise,Tour.legaliteMouvement(plateau,36,54,03), "Pion noir, cas d'une prise de dame vers le bas gauche");
        assertEquals(VariablesGlobales.codeMouvementPionAvecPrise,Tour.legaliteMouvement(plateau,36,58,03), "Pion noir, cas d'une prise vers le bas droit");

        assertEquals(VariablesGlobales.codeMouvementPionAvecPrise,Tour.legaliteMouvement(plateau,76,94,05), "Pion blanc, cas d'une prise vers le bas droit");
        /*Cas Dame*/

        int[][] plateauDame = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,11,13,11,13,11,13,11,13,11},
                /*1*/{11,13,11,13,03,13,03,13,11,13},
                /*2*/{13,06,13,11,13,11,13,10,13,11},
                /*3*/{11,13,11,13,11,13,11,13,05,13},
                /*4*/{13,11,13,10,13,11,13,03,13,11},
                /*5*/{11,13,03,13,11,13,11,13,11,13},
                /*6*/{13,11,13,11,13,11,13,11,13,10},
                /*7*/{11,13,05,13,11,13,03,13,11,13},
                /*8*/{13,11,13,06,13,11,13,11,13,11},
                /*9*/{11,13,11,13,11,13,11,13,11,13}
        };

        assertEquals(VariablesGlobales.codeMouvementDameSansPrise,Tour.legaliteMouvement(plateauDame,21,3,03),"Dame Noire, mouvement simple vers haut droit");
        assertEquals(VariablesGlobales.codeMouvementDameSansPrise,Tour.legaliteMouvement(plateauDame,21,10,03),"Dame Noire, mouvement simple vers haut gauche");
        assertEquals(VariablesGlobales.codeMouvementDameSansPrise,Tour.legaliteMouvement(plateauDame,21,30,03),"Dame Noire, mouvement simple vers bas gauche");
        assertEquals(VariablesGlobales.codeMouvementDameSansPrise,Tour.legaliteMouvement(plateauDame,21,32,03),"Dame Noire, mouvement simple vers bas droit");

        assertEquals(VariablesGlobales.codeMouvementDameSansPrise,Tour.legaliteMouvement(plateauDame,43,65,05),"Dame Blanche, mouvement simple vers bas droit");

        assertEquals(VariablesGlobales.codeMouvementDameAvecPrise,Tour.legaliteMouvement(plateauDame,43,7,05),"Dame blanche, cas prise haut droit");
        assertEquals(VariablesGlobales.codeMouvementDameAvecPrise,Tour.legaliteMouvement(plateauDame,43,10,05),"Dame blanche, cas prise d'une dame haut gauche, atteri au bord et à cote de la prise");
        assertEquals(VariablesGlobales.codeMouvementDameAvecPrise,Tour.legaliteMouvement(plateauDame,43,70,05),"Dame blanche, cas prise bas gauche, atteri case avec espace prise");
        assertEquals(VariablesGlobales.codeMouvementDameAvecPrise,Tour.legaliteMouvement(plateauDame,43,87,05),"Dame blanche, cas prise bas droit");

        assertEquals(VariablesGlobales.codeMouvementDameAvecPrise,Tour.legaliteMouvement(plateauDame,21,65,03),"Dame noire, cas prise bas droit");

        assertEquals(VariablesGlobales.codeErreurMouvementDameImpossible,Tour.legaliteMouvement(plateauDame,27,81,05),"Dame Blanche, tentative de prendre sa propre piece, bas gauche");
        assertEquals(VariablesGlobales.codeErreurMouvementDameImpossible,Tour.legaliteMouvement(plateauDame,83,29,03),"Dame Noire, prise impossible car obstacle, haut droit");
        assertEquals(VariablesGlobales.codeErreurMouvementDameImpossible,Tour.legaliteMouvement(plateauDame,21,98,03),"Dame Noire, prise impossible car obstacle, bas droit");
        assertEquals(VariablesGlobales.codeErreurMouvementDameImpossible,Tour.legaliteMouvement(plateauDame,69,03,05),"Dame Blanche, prise impossible car obstacle, haut gauche");

        //Prise impossible

        int[][] plateauErreursMouvementImpossible = {
                /*  0,  1 , 2,  3,  4,  5,  6,  7,  8,  9*/
                /*0*/{13, 03, 13, 10, 13, 03, 13, 11, 13, 11},
                /*1*/{11, 13, 05, 13, 11, 13, 05, 13, 11, 13},
                /*2*/{13, 11, 13, 05, 13, 11, 13, 11, 13, 11},
                /*3*/{11, 13, 11, 13, 11, 13, 11, 13, 11, 13},
                /*4*/{13, 11, 13, 11, 13, 11, 13, 05, 13, 11},
                /*5*/{11, 13, 11, 13, 11, 13, 05, 13, 11, 13},
                /*6*/{13, 11, 13, 11, 13, 11, 13, 11, 13, 11},
                /*7*/{11, 13, 11, 13, 10, 13, 11, 13, 11, 13},
                /*8*/{13, 03, 13, 11, 13, 05, 13, 11, 13, 11},
                /*9*/{06, 13, 11, 13, 11, 13, 10, 13, 11, 13}

        };

        assertEquals(VariablesGlobales.codeErreurMouvementPionImpossible, Tour.legaliteMouvement(plateauErreursMouvementImpossible, 01, 34, 03), "pion noir veut effectuer mouvement impossible : manger 2 pièces blanches");
        assertEquals(VariablesGlobales.codeErreurMouvementDameImpossible, Tour.legaliteMouvement(plateauErreursMouvementImpossible,90, 72 , 03), "dame noire veut effectuer mouvement impossible : manger pièce noire ");
        assertEquals(VariablesGlobales.codeErreurMouvementPionImpossible, Tour.legaliteMouvement(plateauErreursMouvementImpossible, 56, 38, 05), "pion blanc veut effectuer mouvement impossible : manger pièce blanche");
        assertEquals(VariablesGlobales.codeErreurMouvementDameImpossible, Tour.legaliteMouvement(plateauErreursMouvementImpossible, 96, 63,  05), "dame blanche veut effectuer mouvement impossible : manger 2 pièces noires");
    }

}

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
public class PartieTest {

    @Test
    public final void gagnantTest(){
        int[][] plateauVide = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,11,13,11,13,11,13,11,13,11},
                /*1*/{11,13,11,13,11,13,11,13,11,13},
                /*2*/{13,11,13,11,13,11,13,11,13,11},
                /*3*/{11,13,11,13,11,13,11,13,11,13},
                /*4*/{13,11,13,11,13,11,13,11,13,11},
                /*5*/{11,13,11,13,11,13,11,13,11,13},
                /*6*/{13,11,13,11,13,11,13,11,13,11},
                /*7*/{11,13,11,13,11,13,11,13,11,13},
                /*8*/{13,11,13,11,13,11,13,11,13,11},
                /*9*/{11,13,11,13,11,13,11,13,11,13}
        };

        int[][] plateauGagnantNoirParPriseComplete = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,11,13,11,13,11,13,11,13,11},
                /*1*/{11,13,11,13,11,13,11,13,11,13},
                /*2*/{13,11,13,11,13,11,13,11,13,11},
                /*3*/{11,13,11,13,03,13,11,13,11,13},
                /*4*/{13,11,13,11,13,11,13,11,13,11},
                /*5*/{11,13,11,13,11,13,11,13,11,13},
                /*6*/{13,06,13,11,13,11,13,06,13,11},
                /*7*/{11,13,11,13,03,13,11,13,11,13},
                /*8*/{13,11,13,11,13,11,13,11,13,11},
                /*9*/{11,13,11,13,11,13,11,13,11,13}
        };

        int[][] plateauGagnantBlancParPriseComplete = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,11,13,11,13,11,13,11,13,11},
                /*1*/{11,13,11,13,11,13,11,13,11,13},
                /*2*/{13,11,13,05,13,11,13,11,13,11},
                /*3*/{11,13,11,13,11,13,10,13,11,13},
                /*4*/{13,11,13,11,13,11,13,11,13,11},
                /*5*/{11,13,11,13,05,13,11,13,11,13},
                /*6*/{13,11,13,11,13,11,13,11,13,11},
                /*7*/{11,13,11,13,11,13,11,13,11,13},
                /*8*/{13,11,13,11,13,11,13,11,13,11},
                /*9*/{11,13,11,13,11,13,11,13,11,13}
        };

        int[][] plateauGagnantBlancParParalysie = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,11,13,11,13,11,13,11,13,11},
                /*1*/{11,13,11,13,10,13,11,13,11,13},
                /*2*/{13,11,13,11,13,11,13,11,13,11},
                /*3*/{11,13,05,13,11,13,11,13,11,13},
                /*4*/{13,11,13,11,13,11,13,11,13,11},
                /*5*/{11,13,11,13,11,13,03,13,03,13},
                /*6*/{13,11,13,11,13,05,13,10,13,10},
                /*7*/{11,13,11,13,10,13,05,13,05,13},
                /*8*/{13,11,13,11,13,11,13,11,13,03},
                /*9*/{11,13,11,13,11,13,11,13,10,13}
        };

        int[][] plateauGagnantNoirParParalysie = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,11,13,11,13,11,13,10,13,10},
                /*1*/{11,13,11,13,11,13,03,13,05,13},
                /*2*/{13,11,13,11,13,03,13,11,13,11},
                /*3*/{11,13,11,13,11,13,11,13,11,13},
                /*4*/{13,11,13,11,13,11,13,11,13,11},
                /*5*/{11,13,11,13,11,13,11,13,11,13},
                /*6*/{13,11,13,11,13,06,13,11,13,11},
                /*7*/{11,13,06,13,11,13,11,13,11,13},
                /*8*/{13,11,13,11,13,11,13,03,13,11},
                /*9*/{11,13,11,13,11,13,11,13,11,13}
        };

        int[][] plateauPasDeGagnantPriseImpossible = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,10,13,11,13,11,13,10,13,11},
                /*1*/{11,13,11,13,11,13,11,13,11,13},
                /*2*/{13,11,13,11,13,11,13,11,13,11},
                /*3*/{11,13,11,13,11,13,11,13,11,13},
                /*4*/{13,03,13,11,13,11,13,11,13,11},
                /*5*/{11,13,11,13,11,13,11,13,11,13},
                /*6*/{13,11,13,06,13,11,13,11,13,11},
                /*7*/{11,13,11,13,11,13,11,13,11,13},
                /*8*/{13,11,13,11,13,11,13,06,13,11},
                /*9*/{11,13,11,13,11,13,11,13,11,13}
        };

        int[][] plateauPasDeGagnantPrisePossible = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,10,13,11,13,11,13,10,13,11},
                /*1*/{11,13,11,13,11,13,11,13,11,13},
                /*2*/{13,11,13,11,13,11,13,11,13,11},
                /*3*/{11,13,11,13,11,13,11,13,11,13},
                /*4*/{13,03,13,11,13,11,13,11,13,11},
                /*5*/{11,13,11,13,11,13,11,13,11,13},
                /*6*/{13,11,13,06,13,11,13,11,13,11},
                /*7*/{11,13,11,13,11,13,11,13,03,13},
                /*8*/{13,05,13,11,13,11,13,06,13,11},
                /*9*/{11,13,11,13,11,13,11,13,11,13}
        };

        assertEquals(-1, Partie.gagnant(plateauPasDeGagnantPriseImpossible, 05,false), "Pas Gagnant, pas de prise possible pour noir");
        assertEquals(-1, Partie.gagnant(plateauPasDeGagnantPriseImpossible, 03,false), "Pas Gagnant, pas de prise possible pour blanc");

        assertEquals(-1, Partie.gagnant(plateauPasDeGagnantPrisePossible, 05,false), "Pas Gagnant, prise possible pour noir");
        assertEquals(-1, Partie.gagnant(plateauPasDeGagnantPrisePossible, 03,false), "Pas Gagnant, prise possible pour blanc");

        assertEquals(05, Partie.gagnant(plateauGagnantBlancParPriseComplete,05,false), "Gagnant Joueur Un : Prise complète");
        assertEquals(03, Partie.gagnant(plateauGagnantNoirParPriseComplete,03,false), "Gagnant Joueur Deux : Prise complète");
        assertEquals(05, Partie.gagnant(plateauGagnantBlancParParalysie,05,false), "Gagnant Joueur Un : Paralysie de l'adversaire");
        assertEquals(03, Partie.gagnant(plateauGagnantNoirParParalysie,03,false), "Gagnant Joueur Deux : Paralysie de l'adversaire");

        assertEquals(03, Partie.gagnant(plateauGagnantBlancParParalysie,05,true), "Gagnant Joueur Un : Abandon du joueur deux");
        assertEquals(05, Partie.gagnant(plateauGagnantNoirParParalysie,03,true), "Gagnant Joueur Deux : Abandon du joueur un");


    }

    @Test
    public final void estBloqueTest(){
        int[][] plateauVide = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,03,13,03,13,11,13,11,13,06},
                /*1*/{03,13,06,13,11,13,11,13,10,13},
                /*2*/{13,03,13,03,13,11,13,10,13,11},
                /*3*/{11,13,11,13,11,13,11,13,11,13},
                /*4*/{13,11,13,05,13,05,13,11,13,11},
                /*5*/{11,13,11,13,05,13,11,13,05,13},
                /*6*/{13,11,13,11,13,06,13,11,13,03},
                /*7*/{05,13,10,13,11,13,11,13,03,13},
                /*8*/{13,05,13,11,13,11,13,05,13,10},
                /*9*/{11,13,11,13,11,13,11,13,06,13}
        };

        assertTrue(Partie.estBloquee(plateauVide, 12), "Dame Noire bloquée par ses pairs");
        assertTrue(Partie.estBloquee(plateauVide, 9), "Dame Noire bloquée par piece adversaire");
        assertTrue(Partie.estBloquee(plateauVide, 81), "Pion Blanc bloqué par ses pairs");
        assertTrue(Partie.estBloquee(plateauVide, 1), "Pion noir bloqué par ses pairs");

        assertFalse(Partie.estBloquee(plateauVide, 18), "Dame Blanche pouvant se déplacer mais pas mangé");
        assertFalse(Partie.estBloquee(plateauVide, 98), "Dame Noire pouvant que manger");
        assertFalse(Partie.estBloquee(plateauVide, 69), "Pion noir ne pouvant que manger");
        assertFalse(Partie.estBloquee(plateauVide, 54), "Pion blanc ne pouvant que manger");
        assertFalse(Partie.estBloquee(plateauVide, 3), "Pion noir pouvant se deplacer" );
        assertFalse(Partie.estBloquee(plateauVide, 70), "Pion blanc pouvant se deplacer");

    }

    @Test
    public final void promotionDameTest(){

        int[][] plateauAvant = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,05,13,10,13,05,13,03,13,05},
                /*1*/{11,13,11,13,11,13,11,13,11,13},
                /*2*/{13,11,13,11,13,11,13,11,13,11},
                /*3*/{11,13,11,13,03,13,11,13,11,13},
                /*4*/{13,11,13,11,13,11,13,11,13,11},
                /*5*/{11,13,11,13,11,13,11,13,11,13},
                /*6*/{13,11,13,11,13,11,13,11,13,11},
                /*7*/{11,13,11,13,11,13,11,13,11,13},
                /*8*/{13,11,13,11,13,11,13,11,13,11},
                /*9*/{10,13,11,13,03,13,06,13,05,13}
        };

        //Cas Promotion Dame Blanche

        int[][] plateauAModifieBlanc = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,05,13,10,13,05,13,03,13,05},
                /*1*/{11,13,11,13,11,13,11,13,11,13},
                /*2*/{13,11,13,11,13,11,13,11,13,11},
                /*3*/{11,13,11,13,03,13,11,13,11,13},
                /*4*/{13,11,13,11,13,11,13,11,13,11},
                /*5*/{11,13,11,13,11,13,11,13,11,13},
                /*6*/{13,11,13,11,13,11,13,11,13,11},
                /*7*/{11,13,11,13,11,13,11,13,11,13},
                /*8*/{13,11,13,11,13,11,13,11,13,11},
                /*9*/{10,13,11,13,03,13,06,13,05,13}
        };

        int[][] plateauAttenduBlanc = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,10,13,10,13,10,13,03,13,10},
                /*1*/{11,13,11,13,11,13,11,13,11,13},
                /*2*/{13,11,13,11,13,11,13,11,13,11},
                /*3*/{11,13,11,13,03,13,11,13,11,13},
                /*4*/{13,11,13,11,13,11,13,11,13,11},
                /*5*/{11,13,11,13,11,13,11,13,11,13},
                /*6*/{13,11,13,11,13,11,13,11,13,11},
                /*7*/{11,13,11,13,11,13,11,13,11,13},
                /*8*/{13,11,13,11,13,11,13,11,13,11},
                /*9*/{10,13,11,13,03,13,06,13,05,13}
        };

        Partie.promotionDame(plateauAModifieBlanc, 05);
        assertArrayEquals(plateauAttenduBlanc, plateauAModifieBlanc, "Blanc : cas avec 3 promotions et deux pieces inchangées" );

        //Cas promotion Dame Noire
        int[][] plateauAModifieNoir = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,05,13,10,13,05,13,03,13,11},
                /*1*/{11,13,11,13,11,13,11,13,11,13},
                /*2*/{13,11,13,11,13,11,13,11,13,11},
                /*3*/{11,13,11,13,03,13,11,13,11,13},
                /*4*/{13,11,13,11,13,11,13,11,13,11},
                /*5*/{11,13,11,13,11,13,11,13,11,13},
                /*6*/{13,11,13,11,13,11,13,11,13,11},
                /*7*/{11,13,11,13,11,13,11,13,11,13},
                /*8*/{13,11,13,11,13,11,13,11,13,11},
                /*9*/{03,13,05,13,10,13,06,13,03,13}
        };

        int[][] plateauAttenduNoir = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,05,13,10,13,05,13,03,13,11},
                /*1*/{11,13,11,13,11,13,11,13,11,13},
                /*2*/{13,11,13,11,13,11,13,11,13,11},
                /*3*/{11,13,11,13,03,13,11,13,11,13},
                /*4*/{13,11,13,11,13,11,13,11,13,11},
                /*5*/{11,13,11,13,11,13,11,13,11,13},
                /*6*/{13,11,13,11,13,11,13,11,13,11},
                /*7*/{11,13,11,13,11,13,11,13,11,13},
                /*8*/{13,11,13,11,13,11,13,11,13,11},
                /*9*/{06,13,05,13,10,13,06,13,06,13}
        };

        Partie.promotionDame(plateauAModifieNoir, 03);
        assertArrayEquals(plateauAttenduNoir, plateauAttenduNoir, "Noir : cas avec 3 promotions et deux pieces inchangées");

        //Cas sans promotion

        int[][] plateauAModifieSansPromotion = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,03,13,10,13,06,13,11,13,03},
                /*1*/{11,13,11,13,11,13,11,13,11,13},
                /*2*/{13,11,13,11,13,11,13,11,13,11},
                /*3*/{11,13,11,13,03,13,11,13,11,13},
                /*4*/{13,11,13,11,13,11,13,11,13,11},
                /*5*/{11,13,11,13,11,13,11,13,11,13},
                /*6*/{13,11,13,11,13,11,13,11,13,11},
                /*7*/{11,13,11,13,11,13,11,13,11,13},
                /*8*/{13,11,13,11,13,11,13,11,13,11},
                /*9*/{03,13,05,13,10,13,06,13,03,13}
        };

        int[][] plateauAttenduSansPromotion = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,03,13,10,13,06,13,11,13,03},
                /*1*/{11,13,11,13,11,13,11,13,11,13},
                /*2*/{13,11,13,11,13,11,13,11,13,11},
                /*3*/{11,13,11,13,03,13,11,13,11,13},
                /*4*/{13,11,13,11,13,11,13,11,13,11},
                /*5*/{11,13,11,13,11,13,11,13,11,13},
                /*6*/{13,11,13,11,13,11,13,11,13,11},
                /*7*/{11,13,11,13,11,13,11,13,11,13},
                /*8*/{13,11,13,11,13,11,13,11,13,11},
                /*9*/{03,13,05,13,10,13,06,13,03,13}
        };

        Partie.promotionDame(plateauAModifieSansPromotion,05);
        assertArrayEquals(plateauAttenduSansPromotion, plateauAModifieSansPromotion, "Cas sans promotion");
    }

}

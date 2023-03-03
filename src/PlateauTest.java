import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PlateauTest {
    @Test
    public final void creationRemplissagePlateauTest(){

        int[][] plateauNouvellePartie = {
                /*     0, 1, 2, 3, 4, 5, 6, 7, 8, 9*/
                /*0*/{13,03,13,03,13,03,13,03,13,03},
                /*1*/{03,13,03,13,03,13,03,13,03,13},
                /*2*/{13,03,13,03,13,03,13,03,13,03},
                /*3*/{03,13,03,13,03,13,03,13,03,13},
                /*4*/{13,11,13,11,13,11,13,11,13,11},
                /*5*/{11,13,11,13,11,13,11,13,11,13},
                /*6*/{13,05,13,05,13,05,13,05,13,05},
                /*7*/{05,13,05,13,05,13,05,13,05,13},
                /*8*/{13,05,13,05,13,05,13,05,13,05},
                /*9*/{05,13,05,13,05,13,05,13,05,13}
        };

        assertArrayEquals(plateauNouvellePartie, Plateau.creationRemplissagePlateau());
    }
}

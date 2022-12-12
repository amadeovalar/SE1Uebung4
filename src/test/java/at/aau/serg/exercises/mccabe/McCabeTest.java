package at.aau.serg.exercises.mccabe;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class McCabeTest {

    @Test
    public void pathOneTest() {
        McCabe mcCabe = new McCabe();
        int zahl1 = 5;
        int zahl2 = 0;
        int mcCabeResult = mcCabe.ggt(zahl1, zahl2);

        assertEquals(zahl1, mcCabeResult);
    }
    @Test
    public void pathTwoTest() {
        McCabe mcCabe = new McCabe();
        int zahl1 = 5;
        int zahl2 = 4;
        int mcCabeResult = mcCabe.ggt(zahl1, zahl2);

        assertEquals(1, mcCabeResult);
    }
    @Test
    public void pathThreeTest() {
        McCabe mcCabe = new McCabe();
        int zahl1 = 4;
        int zahl2 = 5;
        int mcCabeResult = mcCabe.ggt(zahl1, zahl2);

        assertEquals(1, mcCabeResult);
    }

}

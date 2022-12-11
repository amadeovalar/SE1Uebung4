// Amadeo Valar 11717299
package at.aau.serg.exercises.shapetesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class RectangularShapeFactoryTest {

    RectangularShapeFactory shapeFactory;

    @BeforeEach
    void setUp() {
        shapeFactory = new RectangularShapeFactory();  
    }
     

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20})
    // Equilateral Tests
    public void equilateralSquareTest(int sideLenght) {
        Square testSquare = (Square) shapeFactory.create(sideLenght);

        assertTrue(testSquare.isEquilateral());

    }

    @Test
    public void equilateralRectangleTest() {
        Rectangle testRectangle = (Rectangle) shapeFactory.create(5, 6);

        assertFalse(testRectangle.isEquilateral());
    }

    @Test
    // Äquivalenz Tests
    public void equivalenceEqualSquareTest() {
        Square normalSquareOne = (Square) shapeFactory.create(10);
        Square normalSquareTwo = (Square) shapeFactory.create(10);
        

        assertEquals(normalSquareOne, normalSquareTwo);
    }
    @Test
    // Äquivalenz Tests - Square
    public void equivalenceNotEqualSquareTest() {
        Square normalSquareOne = (Square) shapeFactory.create(10);
        Square normalSquareTwo = (Square) shapeFactory.create(12);
        

        assertNotEquals(normalSquareOne, normalSquareTwo);
    }

    @Test
    public void equivalenceEqualRectangleTest() {
        Rectangle equalSideRectangleOne = (Rectangle) shapeFactory.create(12, 10);
        Rectangle equalSideRectangleTwo = (Rectangle) shapeFactory.create(12, 10);

        assertEquals(equalSideRectangleOne, equalSideRectangleTwo);
    }

    @Test
    public void equivalenceNotEqualRectangleTest() {
        Rectangle notEqualSideRectangleOne = (Rectangle) shapeFactory.create(5, 2);
        Rectangle notEqualSideRectangleTwo = (Rectangle) shapeFactory.create(12, 10);

        assertNotEquals(notEqualSideRectangleOne, notEqualSideRectangleTwo);
    }

    @Test
    // Execptions Tests
    public void execptionTest() {
        // Test für Square
        assertThrows(IllegalArgumentException.class, () -> shapeFactory.create(0));
        // Test für Rectangle
        assertThrows(IllegalArgumentException.class, () -> shapeFactory.create(0, 5));
        // Test für Rectangle
        assertThrows(IllegalArgumentException.class, () -> shapeFactory.create(5, 0));
    }

    @Test
    // 4 Side Objekte Test
    public void getSidesTestSquare() {
        int side = 5;
        Square squareSides = (Square) shapeFactory.create(side);

        Iterator<Side> iter = squareSides.getSides().iterator();

        while (iter.hasNext()) {
            assertEquals(side, iter.next().getLength());
        }
        // assertEquals(side, squareSides.getSides().get(0).getLength());
        // assertEquals(side, squareSides.getSides().get(1).getLength());
        // assertEquals(side, squareSides.getSides().get(2).getLength());
        // assertEquals(side, squareSides.getSides().get(3).getLength());
    }

    @Test
    public void getsidesTestRectangle() {
        int width = 10;
        int height = 12;

        Rectangle rectangleSides = (Rectangle) shapeFactory.create(width, height);;

        for (int i = 0; i < rectangleSides.getSides().size(); i++) {
            if (i % 2 == 0) {
                assertEquals(height, rectangleSides.getSides().get(i).getLength());
            } else {
                assertEquals(width, rectangleSides.getSides().get(i).getLength());
            }

        }

    }

}
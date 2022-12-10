// Amadeo Valar 11717299
package at.aau.serg.exercises.shapetesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class RectangularShapeFactoryTest {
    
    RectangularShapeFactory shapeFactory = new RectangularShapeFactory();
    
    @Test
    // Equilateral Tests
    public void equilateralSquareTest() {
        Square testSquare = (Square) shapeFactory.create(5);

        assertTrue(testSquare.isEquilateral());

    }
    
    @Test
    public void equilateralRectangleTest() {
        Rectangle testRectangle = (Rectangle) shapeFactory.create(5, 6);

        assertFalse(testRectangle.isEquilateral());
    }
    
    @Test
    // Äquivalenz Tests
    public void equivalenceTest() {
        Square normalSquare = new Square(10);
        Rectangle equalsideRectangle = new Rectangle(10, 10);

        assertEquals(normalSquare, equalsideRectangle);
    }
    
    @Test
    public void equivalenceNotTest() {
        Square secondNormalSquare = new Square(20);
        Rectangle notEqualSideRectangle = new Rectangle(10, 15);

        assertNotEquals(secondNormalSquare, notEqualSideRectangle);
    }

    
    
    
    
    
}
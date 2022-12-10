// Amadeo Valar 11717299
package at.aau.serg.exercises.shapetesting;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class RectangularShapeFactoryTest {
    
    RectangularShapeFactory shapeFactory = new RectangularShapeFactory();
    
    @Test
    public void equilateralSquareTest() {
        Square testSquare = (Square) shapeFactory.create(5);

        assertTrue(testSquare.isEquilateral());

    }
    
    public void equilateralRectangleTest() {
        Rectangle testRectangle = (Rectangle) shapeFactory.create(5, 6);

        assertFalse(testRectangle.isEquilateral());
    }
    
    
    
}
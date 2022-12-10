// Amadeo Valar 11717299
package at.aau.serg.exercises.shapetesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class RectangularShapeFactoryTest {
    
    // @BeforeAll
    // public RectangularShape setUp(int width, int height) {
    //     RectangularShapeFactory shapeFactory = new RectangularShapeFactory();
    //     if (width == height) {
    //         RectangularShape shape = shapeFactory.create(width);
    //     } else {
    //         RectangularShape shape = shapeFactory.create(width, height);
    //     }
        
    //     return shape;
    // }
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

    @Test
    // Execptions Tests
    public void execptionTest() {
        // Test für Square
        assertThrows(IllegalArgumentException.class, () -> shapeFactory.create(0));
        // Test für Rectangle
        assertThrows(IllegalArgumentException.class, () -> shapeFactory.create(0,5));
    }

    @Test
    // 4 Side Objekte Test
    public void getSidesTestSquare() {
        int side = 5;
        Square squareSides = new Square(side);

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
        int height = 10;

        Rectangle rectangleSides = new Rectangle(width, height);
        
        for (int i = 0; i < rectangleSides.getSides().size(); i++) {
            if(i % 2 == 0){
                assertEquals(height, rectangleSides.getSides().get(i).getLength());
            } else {
                assertEquals(width, rectangleSides.getSides().get(i).getLength());
            }
            
        }

    }

    
    
    
    
}
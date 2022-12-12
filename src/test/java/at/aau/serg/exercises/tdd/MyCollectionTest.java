package at.aau.serg.exercises.tdd;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;


public class MyCollectionTest
{
    @Test
    public void testEmptyListRemoveMethodException() {
        int capacity = 2;
        MyCollection myCollection = new MyCollection(capacity);

        String testString = "Test";
        assertThrows(IllegalArgumentException.class, () -> myCollection.remove(testString));
    }
    
    @Test
    public void testElementNotInThePopulatedListRemoveMethodException() {
        int capacity = 2;
        MyCollection myCollection = new MyCollection(capacity);
        
        myCollection.add("First element");
        myCollection.add("Second element");
        
        String testString = "Test";

        assertThrows(IllegalArgumentException.class, () -> myCollection.remove(testString));
        
    }

    @Test
    public void testArraySizeAfterRemove() {
        int capacity = 2;
        MyCollection myCollection = new MyCollection(capacity);

        String firstElement = "First element";
        String secondElement = "Second element";

        myCollection.add(firstElement);
        myCollection.add(secondElement);


        myCollection.remove(firstElement);

        assertEquals(capacity - 1, myCollection.size());
    }
}

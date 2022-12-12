package at.aau.serg.exercises.tdd;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class MyCollectionTest
{
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

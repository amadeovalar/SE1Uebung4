package at.aau.serg.exercises.ringbuffer;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

// @RunWith(JUnitPlatform.class)
public class BaseTest {

    // RingBuffer ringBuffer;

    // @BeforeEach
    // void setUp() {
    //     ringBuffer = new RingBuffer<>(50);
    // }

    @Test
    // Testing isEmpty() method
    public void isEmptyTest() {
        RingBuffer ringBuffer = new RingBuffer<>(50);
        assertTrue(ringBuffer.isEmpty());
    }

    @Test
    // Testing isEmptyMethod for the false value
    public void isNotEmptyTest() {
        RingBuffer ringBuffer = new RingBuffer<>(50);
        List<String> testList = List.of("First", "Second", "Third");
        for (String string : testList) {
            ringBuffer.push(string);
        }
        assertFalse(ringBuffer.isEmpty());
    }
    
    @Test
    // Testing the size() method no values added to the buffer
    public void sizeTest() {
        RingBuffer ringBuffer = new RingBuffer<>(50);
        assertEquals(0, ringBuffer.size());
    }
    
    @Test
    // Testing the size() method no values added to the buffer
    public void sizeValuesAddedTest() {
        RingBuffer ringBuffer = new RingBuffer<>(50);
        List<String> testList = List.of("First", "Second", "Third");
        for (String string : testList) {
            ringBuffer.push(string);
        }
        assertEquals(testList.size(), ringBuffer.size());
    }



}

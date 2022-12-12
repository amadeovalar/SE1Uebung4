package at.aau.serg.exercises.ringbuffer;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;


// import org.junit.platform.runner.JUnitPlatform;
// import org.junit.runner.RunWith;

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
    // Testing the size() method with values added to the buffer
    public void sizeValuesAddedTest() {
        RingBuffer ringBuffer = new RingBuffer<>(50);
        List<String> testList = List.of("First", "Second", "Third");
        for (String string : testList) {
            ringBuffer.push(string);
        }
        assertEquals(testList.size(), ringBuffer.size());
    }

    @Test
    // Push method exeption testing
    public void pushExceptionTest() {
        RingBuffer ringBuffer = new RingBuffer<>(3);
        List<String> testList = List.of("First", "Second", "Third", "fourth");
        
        assertThrows(RuntimeException.class, () -> addItemsToBuffer(ringBuffer, testList));

    }
    
    @Test
    // Pop() method exception testing
    public void popExceptionTesting() {
        RingBuffer ringBuffer = new RingBuffer<>(3);
        
        assertThrows(RuntimeException.class, () -> ringBuffer.pop());
    }
    
    @Test
    // Testing the pop() method 
    public void popMethodTest() {
        RingBuffer ringBuffer = new RingBuffer<>(3);
        List<String> testList = List.of("First", "Second", "Third");
        for (String string : testList) {
            ringBuffer.push(string);
        }
        ringBuffer.pop();

        assertEquals(testList.size() - 1, ringBuffer.size());
    }

    @Test
    // Testing the iterator method
    public void iteratorTest() {
        RingBuffer ringBuffer = new RingBuffer<>(3);
        Iterator<RingBuffer> iter = ringBuffer.iterator();

        while (iter.hasNext()) {
            assertTrue(iter.next().isEmpty());
        }

    }

    @Test
    public void iteratorNextMethodTest() {
        RingBuffer ringBuffer = new RingBuffer<>(3);
        List<String> testList = List.of("First", "Second", "Third");
        for (String string : testList) {
            ringBuffer.push(string);
        }
        Iterator<RingBuffer> iter = ringBuffer.iterator();

        assertEquals(testList.get(0), iter.next());
        
    }

    @Test
    // Testing the iterator method
    public void iteratorHasNextMethodTest() {
        RingBuffer ringBuffer = new RingBuffer<>(3);
        List<String> testList = List.of("First", "Second", "Third");
        for (String string : testList) {
            ringBuffer.push(string);
        }
        Iterator<RingBuffer> iter = ringBuffer.iterator();
        assertTrue(iter.hasNext());

    }
    
    @Test
    public void iteratorRemoveMethodExceptionTest() {
        RingBuffer ringBuffer = new RingBuffer<>(3);
        Iterator<RingBuffer> iter = ringBuffer.iterator();

        assertThrows(UnsupportedOperationException.class, () -> iter.remove());
    }
    
    @Test
    public void iteratorNextExceptionTest() {
        RingBuffer ringBuffer = new RingBuffer<>(3);
        Iterator<RingBuffer> iter = ringBuffer.iterator();
        
        assertThrows(NoSuchElementException.class, () -> iter.next());
    }
    
    private void addItemsToBuffer(RingBuffer ringBuffer, List<String> testList) {
        for (String string : testList) {
                ringBuffer.push(string);}
    }


}
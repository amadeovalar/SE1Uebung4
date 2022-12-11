package at.aau.serg.exercises.ringbuffer;

import java.util.List;

public class Playground {
    public static void main(String[] args) {
        int capacity = 50; 
        RingBuffer testRing = new RingBuffer<>(capacity);

        // Test integer
        int testInt = 25;

        List<String> testList = List.of("This", "element", "is", "in", "buffer");
        
        for (String string : testList) {
            testRing.push(string);
        }

        System.out.println("Size after push: " + testRing.size());

        testRing.pop();

        System.out.println("Size after pop: " + testRing.size());

        System.out.println(testRing.isEmpty());

    }
}

package at.aau.serg.exercises.tdd;

public class Playground {
    public static void main(String[] args) {
        int capacity = 5;
        MyCollection myCollection = new MyCollection(capacity);

        
        myCollection.add("First element");
        // myCollection.add("Second element");
        // myCollection.add("Third element");
        // myCollection.add("Fourth element");
        // myCollection.add("Fifth element");
        // // myCollection.add("Sixth element");
        
        System.out.println(myCollection.getCursor());
        
    }
}

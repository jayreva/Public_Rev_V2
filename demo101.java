package demos;

import java.util.Iterator;
import java.util.LinkedList;

public class demo101 {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.add("Mark");
        names.add("Paul");
        names.add("Watson");
        System.out.println(names);

        names.add(0, "John");
        System.out.println(names);

        LinkedList<String> namesNew = new LinkedList<>();
        namesNew.add("Stacy");
        namesNew.add("Smith");

        names.addAll(namesNew);
        System.out.println(names);

        names.addAll(0, namesNew);
        System.out.println(names);

        names.addFirst("First");
        names.addLast("Last");
        System.out.println(names);

        //remove()
        //removeFirst()
        //removeLast()
        //removeFirstOccurrence
        //removeLastOccurrence

        names.add("John");
        names.add("Paul");
        System.out.println(names);

        names.removeFirstOccurrence("John");
        System.out.println(names);

        System.out.println("Original");
        System.out.println(names);

        //reverse elements
        Iterator iterator = names.descendingIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for(int i = names.size()-1; i > 0; i--){
            System.out.println(names.get(i));
        }
    }
}

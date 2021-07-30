package demos;

import java.util.Iterator;
import java.util.LinkedList;

public class demo100 {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.add("Mark");
        names.add("Paul");
        names.add("Watson");

        Iterator<String> iterator = names.iterator();
        while(iterator.hasNext()){

        }
    }
}

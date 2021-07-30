package demos;

import java.util.HashSet;
import java.util.Iterator;

public class demo102 {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Mark");
        set.add("Paul");
        set.add("Watson");
        set.add("John");
        set.add(null);
        set.add(null); //redundant

        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //remove()
        //removeAll()
        //

        set.remove("Paul");
        System.out.println(set);


    }
}

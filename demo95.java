package demos;

import java.util.ArrayList;

public class demo95 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Mark");
        names.add("Paul");
        names.add("Watson");

        System.out.println(names.get(1));
        names.set(1,"Paul Smith");
        for (String name: names){
            System.out.println(names);
        }
    }
}

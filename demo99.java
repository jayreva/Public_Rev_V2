package demos;

import java.util.ArrayList;

public class demo99 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Mark");
        names.add("Paul");
        names.add("Stacy");
        names.add("Watson");

        System.out.println(names.get(1));

        names.add(1, "John");
        System.out.println(names);

        ArrayList<String> newList = new ArrayList<>();
        newList.add("Rangel");
        newList.add("Smith");
        //names.addAll(newList);

        names.addAll(0,newList);
        System.out.println(names);

        names.remove("Mark");
        System.out.println(names);

        names.remove(0);
        System.out.println(names);

        names.removeAll(newList);
        System.out.println(names);

        names.removeIf(name -> name.contains("Paul"));
        System.out.println(names);
    }
}

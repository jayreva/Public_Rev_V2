package demos;

import java.util.TreeSet;

public class demo104 {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Mark");
        treeSet.add("Paul");
        treeSet.add("Watson");
        treeSet.add("John");

        for(String name: treeSet){
            System.out.println(name);
        }
    }
}

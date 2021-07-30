package demos;

import java.util.ArrayList;
import java.util.Collections;

public class demo111 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(); //1
        colors.add("blue");
        colors.add("green");
        colors.add("red");
        colors.add("yellow");
        colors.add("orange");
        System.out.println(colors);

        colors.forEach(color -> {
            System.out.println(color); //2
        });

        colors.add(0, "purple"); //3
        System.out.println(colors);

        System.out.println(colors.get(2)); //4

        colors.add(2, "pink"); //5
        System.out.println(colors);

        colors.remove(2); //6
        System.out.println(colors);

        for (String color : colors) {
            if (colors.contains("orange")) { //7
                System.out.println(color);
            }
        }

        Collections.sort(colors); //8
        System.out.println(colors);

        ArrayList<String> newColors = new ArrayList<>();
        newColors.add("beige");
        newColors.add("white");
        newColors.add("black");
        colors.addAll(newColors); //9

        Collections.shuffle(colors); //10
        System.out.println(colors);

        Collections.reverse(colors); //11
        System.out.println(colors);

        System.out.println(colors.subList(0,3)); //12

        Collections.swap(colors, 1,2);
        System.out.println(colors); //13


    }
}



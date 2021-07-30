package demos;

import java.util.ArrayList;
import java.util.Collections;

public class demo96 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("yellow");
        colors.add("red");
        colors.add("orange");
        colors.add("blue");
        colors.add("pink");

        for (String color: colors)
        System.out.println(color);

        Collections.sort(colors);
        for (String color: colors)
            System.out.println(color);

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(8);
        numbers.add(2);
        numbers.add(5);
        numbers.add(4);

        for (int number: numbers)
            System.out.println(number);

        Collections.sort(numbers);
        for (int number: numbers)
            System.out.println(number);
    }
}

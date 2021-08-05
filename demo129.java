package demos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class demo129 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(2);
        numbers.add(1);
        numbers.add(4);
        numbers.add(3);
        numbers.add(5);

        for (int number: numbers)
            System.out.println(number);


        Collections.sort(numbers);

        for (int number : numbers)
            System.out.println(number);

    }
}

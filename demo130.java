package demos;

import java.util.ArrayList;
import java.util.Collections;

public class demo130 {
    public static void main(String[] args) {

        ArrayList<String> letters = new ArrayList<>();
        letters.add("C");
        letters.add("D");
        letters.add("A");
        letters.add("E");
        letters.add("B");

        for (String letter : letters)
            System.out.println(letter);


        Collections.sort(letters);

        for (String letter : letters)
            System.out.println(letter);


    }
}

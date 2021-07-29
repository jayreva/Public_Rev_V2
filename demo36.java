package demos;

import java.util.Arrays;

public class demo36 {
    public static void main(String[] args) {
        String message = "Hello, welcome to java";
        String[] result = message.split("\\,");
        System.out.println(Arrays.toString(result));
    }
}

package demos;

import java.io.File;

public class demo128 {
    public static void main(String[] args) {
        File file = new File("db");
        System.out.println(file.exists());

        file.mkdir();
    }
}

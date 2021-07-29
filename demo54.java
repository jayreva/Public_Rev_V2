package demos;

import javax.annotation.processing.Filer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class demo54 {
    public static void main(String[] args) {
        BufferedReader bufferedReader= null;
        try {
            bufferedReader = new BufferedReader(new FileReader(data.txt));
            System.out.println(bufferedReader.read());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if (bufferReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {

                }
            }
        }
    }
}

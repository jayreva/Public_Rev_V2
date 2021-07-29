package demos;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class demo57 {
    public static void main(String[] args) {
        try(FileOutputStream fileOutputStream = new FileOutputStream("D:\\somefile.txt") {
            String data = "Hello World";
            // convert String to bytes array
            byte[] arr[] = data.getBytes()
            stream.write(arr);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}

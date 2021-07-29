package demos;

public class demo31 {
    public static void main(String[] args) {


        String s1 = "Mark";
        String s2 = "Mark";
        String s3 = new String("Mark");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }
}
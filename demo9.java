package demos;

public class demo9 {
    public static void main(String[] args) {
        int a = 30;
        int b = 20;
        int c = 10;
        boolean d = true;
        boolean e = false;

        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);

        System.out.println(a>b && a>c);

        System.out.println(a > b || a < c);

        int max = (a < b)? a: b;
        System.out.println(max);
    }
}

package demos;

public class demo70 {
     static class A{

        static int a;

        static {
            a = 20;
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        A a1 = new A();
    }
}

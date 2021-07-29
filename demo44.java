package demos;

public class demo44 {
    public static void main(String[] args) {
        int a = 20;
        int b = 10;
        int c = 0;

        try{
            c = a / b;
        } catch (ArithmeticException ex){
            System.out.println(ex.getMessage());
        } catch (Exception ex) {//generic exception must go last
            System.out.println(ex.getMessage());
        }
    }
}

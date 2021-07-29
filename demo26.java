package demos;


public class demo26 {

    class Calculator{

        int a = 10;
        int b = 20;

        public Calculator(){
            System.out.println("Parameterless constructor");
        }

        public Calculator(int x, int y){
            this.a = x;
            this.b = y;
        }

        public void addNumbers(){
            System.out.println(a + b);
        }

    }

    public static void main(String[] args) {
        Calculator cal = new Calculator();
        cal.addNumbers();

        Calculator cal2 = new Calculator(100, 200);
        cal2.addNumbers();
    }
}

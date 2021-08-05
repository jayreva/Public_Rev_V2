package demos;

public class demo133 {
    static class Calculator{
        private static int count = 0;

        private static Calculator instance = null;

        private Calculator(){
            count++;
            System.out.println("Count: " + count);
            System.out.println("Constructor called");
        }

        public static Calculator getInstance(){
            if (instance == null)
                instance = new Calculator();
            return instance;
        }
    }
    public static void main(String[] args) {
        Calculator calculator1 = new Calculator();
        Calculator calculator2 = new Calculator();
        Calculator calculator3 = new Calculator();

        Calculator calculator4 = Calculator.getInstance();
        Calculator calculator5 = Calculator.getInstance();
        Calculator calculator6 = Calculator.getInstance();


    }
}

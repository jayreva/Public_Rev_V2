package demos;

public class demo141 {
    class Calculator {
//        public boolean areEqual(int a, int b) {
//            if (a == b) {
//                return true;
//            } else
//                return false;
//        }
        public boolean areEqual(Object a, Object b){
            if (a.equals(b)) {
                return true;
            } else
                return false;
        }
    }

    public void main(String[] args) {
        Calculator cal = new Calculator();
        boolean result = cal.areEqual(123.12, 123.12);
        if (result)
            System.out.println("Numbers are equal");
        else
            System.out.println("Numbers are not equal");

    }

}

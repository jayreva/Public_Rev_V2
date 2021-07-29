package demos;

public class demo85 {
//interface I1{
//    void print();
//}
//
//interface I2 extends I1{
//    void display();
//}
//
//class Test5 implements I2{
//
//    @Override
//    public void print() {
//
//    }
//
//    @Override
//    public void display() {
//
//    }
//}

    interface I1{
        void print();
    }

    interface I2{
        void display();
    }

    static class Test5 implements I1, I2 {

        @Override
        public void print() {
            System.out.println("Hello");
        }

        @Override
        public void display() {
            System.out.println("World");
        }
    }
    public void main(String[] args) {
        Test5.print();
        Test5.display();
    }
}


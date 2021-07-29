package demos;

public class demo78 {
    class A1{
        public final void test(){
            System.out.println("A1 : test");
        }
    }

    class B1 extends A1{
        public void test2(){
            test();
        }
    }

    public void main(String[] args) {
        A1 a1 = new A1();
        a1.test();
    }
}

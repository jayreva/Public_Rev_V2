package demos;

class X{
    public void test1(){
        System.out.println("X");
    }
}

class Y extends X{
    public void test2(){
        System.out.println("Y");
    }
}

class Z extends X{
    public void test3(){
        System.out.println("Z");
    }
}

public class demo61 {
    public static void main(String[] args) {
        X x1 = new X();
        x1.test1();
        //x1.test2();
        //x1.test3();

        Y y1 = new Y();
        y1.test1();
        y1.test2();
        //y1.test3();

        Z z1 = new Z();
        z1.test1();
        //z1.test2();
        z1.test3();
    }
}

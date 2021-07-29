package demos;

public class demo76 {
    class Bike{
        public final void drive(){
            System.out.println("driving...");
        }
    }

    class Honda extends Bike{
//    public void drive(){
//        System.out.println("driving...");
//    }     final can't override
    }

    public static void main(String[] args) {

    }
}

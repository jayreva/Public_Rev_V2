package demos;

interface ICar{
    void getCarModel();
    void getCarColor();
}

class Audi implements ICar{

    @Override
    public void getCarModel() {
        System.out.println("Audi A6");
    }

    @Override
    public void getCarColor() {
        System.out.println("Black");
    }
}

class BMW implements ICar{

    @Override
    public void getCarModel() {
        System.out.println("5 Class");
    }

    @Override
    public void getCarColor() {
        System.out.println("White");
    }
}

class CarFactory{
    public static ICar getCarInstance(int id){
        switch (id){
            case 1:
                return new Audi();
            case 2:
                return new BMW();
            default:
                return null;
        }
    }
}

public class demo134 {
    public static void main(String[] args) {
//        Audi car1 = new Audi();
//        car1.getCarModel();
//        car1.getCarColor();
//
//        BMW car2 = new BMW();
//        car2.getCarModel();
//        car2.getCarColor();

        ICar car1 = CarFactory.getCarInstance(2);
        car1.getCarModel();
        car1.getCarColor();
    }
}

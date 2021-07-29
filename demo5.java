package demos;

public class demo5 {
    public interface Purchasable {
        int maxPrice = 50;
        public String buy();
    }

    public static class Furniture implements Purchasable{
        //int maxPrice;
        @Override
        public String buy() {
        //    System.out.println("You bought the chair for: " + maxPrice);
            return ("You bought the chair for: " + maxPrice);
        };
    }

    public static void main(String[] args) {
        Furniture chair = new Furniture();
        //chair.maxPrice = 50;
        System.out.println(chair.buy());
    }
}

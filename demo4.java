package demos;

public class demo4 {
    public static class WaterAnimal {
        static String action = " swims through the water.";
    }

    public static class fish extends WaterAnimal {
        String name;
        //String action = " swims through the water.";
    }

    public static void main(String[] args) {
        fish fish1 = new fish();
        fish1.name = "Trout";
        System.out.println(fish1.name + WaterAnimal.action);
    }
}

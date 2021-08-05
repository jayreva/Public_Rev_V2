package demos;

public class demo145 {

    static class GenericMethodDemo {
        public static <E> void printArray(E[] elements) {
            for (E element : elements) {
                System.out.println(element);
            }
            System.out.println("**********");
        }
    }

    public static void main(String[] args) {
        Integer[] intArray = {10, 20, 30, 40};
        Character[] charArray = {'A', 'B', 'C', 'D'};

        GenericMethodDemo.printArray(intArray);
        GenericMethodDemo.printArray(charArray);
    }
}
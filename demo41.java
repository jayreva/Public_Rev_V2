package demos;

public class demo41 {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("Hello");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            buffer.append("World");
        }

        System.out.println("Time elapsed: " + (System.currentTimeMillis() - startTime) + "ms");

        StringBuilder builder = new StringBuilder("Hello");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            buffer.append("World");
        }

        System.out.println("Time elapsed: " + (System.currentTimeMillis() - startTime) + "ms");
    }
}

package demos;

public class demo86 {
    interface Drawable{
        void draw();
        default void print(){
            System.out.println("printing...");
        }
    }

    static class Rectangle implements Drawable{

        @Override
        public void draw() {
            System.out.println("drawing...");
        }
    }
    public static void main(String[] args) {
        Rectangle rectObj = new Rectangle();
        rectObj.draw();
        rectObj.print();
    }
}

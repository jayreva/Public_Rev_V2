package demos;

public class demo137 {
//    interface Rectangle{
//        public void draw()
//    }
//
//    class Test implements Rectangle{
//
//        @Override
//        public void draw() {
//            System.out.println("drawing...");
//        }
//    }

    interface Rectangle {
        void draw();
    }

    public void main(String[] args) {
//        Test test = new Test();
//        test.draw();


//        Rectangle rectangle = new Rectangle(){
//            @Override
//            public void draw(){
//                System.out.println("drawing");
//            }
//        };
//        rectangle.draw();

        Rectangle rectangle = () -> {
            System.out.println("drawing...");
        };
        rectangle.draw();
    }
}

package demos;

public class demo80 {
    abstract class Shape{
        public double width;
        public double height;
        public double radius;
        public float pie = 3.14f;

        public abstract void getArea();
    }

    class Rectangle extends Shape{
        public Rectangle(double width, double height){
            this.width = width;
            this.height = height;
        }

        public void draw(){
            System.out.println("rectangle drawing...");
        }


        @Override
        public void getArea() {
            System.out.println(width * height);
        }
    }

    class Circle extends Shape{
        public Circle(double radius){
            this.radius = radius;
        }

        public void draw(){
            System.out.println("drawing...");
        }

        @Override
        public void getArea() {
            System.out.println(pie * radius * radius);
        }
    }

    public void main(String[] args) {
        Rectangle rectangle = new Rectangle(12.5, 40.5);
        Circle circle = new Circle(50.5);

        rectangle.draw();
        circle.draw();

        rectangle.getArea();
        circle.getArea();
    }
}

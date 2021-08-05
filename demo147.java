package demos;

import java.util.ArrayList;
import java.util.List;

class Test1{
    public static void drawShape(List<? extends demo147.Shape> list){
        for(demo147.Shape shape: list){
            shape.draw();
        }
    }

}

public class demo147 {

    abstract class Shape{
        abstract void draw();
    }

    class Rectangle extends Shape{
        @Override
        void draw(){
            System.out.println("drawing rectangle");
        }
    }

    class Circle extends Shape{
        @Override
        void draw(){
            System.out.println("drawing circle");
        }
    }

    class Cone {
        void draw(){
            System.out.println("drawing cone");
        }
    }



    public static void main(String[] args) {

        List<Rectangle> rectangleList = new ArrayList<>();
        List<Circle> circleList = new ArrayList<>();
        List<Cone> coneList = new ArrayList<>();

        Test1.drawShape(rectangleList);
        Test1.drawShape(circleList);
        Test1.drawShape(coneList);
    }
}

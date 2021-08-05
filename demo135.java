package demos;

public class demo135 {
//    class Car{
//        Engine engine;
//        Tire tire;
//
//        public  Car(){
//            this.engine = engine;
//            this.tire = tire;
//
//        }
//    }
//
//    class Engine{
//        public Engine (String type){
//
//        }
//    }
//
//    class Tire{
//        public tire (String type){
//
//        }
//    }
    class Engine{

    }

    class Tire{

    }

    class CarFactory2{
        public static void getInstance(int id){
            switch (id){
                case 0:
                    System.out.println("");
                    break;
                case 1:
                    System.out.println("");
                    break;

            }
        }
    }

    class Car{
        Engine engine;
        Tire tire;

        public Car(Engine engine, Tire tire){
            this.engine = engine;
            this.tire = tire;
        }
    }
}

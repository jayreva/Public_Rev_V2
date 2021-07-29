package demos;

public class demo73 {
    class Parent{
        public void greeting(String name){
            System.out.println("Welcome "+ name);
        }
    }

    class Child extends Parent{
        public void greeting(String name){
            System.out.println("Hello "+ name);
        }
    }

    public void main(String[] args) {
        Child child = new Child();
        child.greeting("Mark");
    }
}

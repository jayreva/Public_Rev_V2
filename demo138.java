package demos;

public class demo138 {
    interface Hello{
        public String greeting()
    }

    interface Welcome{
        public String greeting(String name);
    }

    interface Calculation{
        public int addNumber(int a, int b);
    }

    interface Say{
        public void sayHello(String name);
    }

    public static void main(String[] args) {
        Hello hello = () -> {
            return "Welcome Guest";
        };

        System.out.println(hello.greeting());

        Welcome welcome = (name) ->{
            return "Welcome" + name;
        };

        System.out.println(welcome.greeting("Paul"));

        Calculation calculation = (a, b) -> {
            return a + b;
        };

        System.out.println(calculation.addNumber(20, 30));

        Say say = (name) -> {
            System.out.println("Hello " + name);
        };

        say.sayHello("Watson");
    }
}

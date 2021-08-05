package demos;

public class demo146 {

    class Employee<T>{

        String name;

        public <T> Employee(T name){
            this.name = name.toString();
        }
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("Mark");

    }
}

package demos;

public class demo83 {
    interface IEmployee{
        void print();
    }

    class Employee2 implements IEmployee{
        @Override
        public void print() {
            System.out.println("Interface print method");
        }
    }

    public void main(String[] args) {
        Employee2 emp = new Employee2();
        emp.print();
    }
}

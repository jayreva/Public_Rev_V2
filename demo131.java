package demos;

import java.util.ArrayList;
import java.util.Collections;

public class demo131 {
    class Employee implements Comparable<Employee>{
        public int id;
        public String name;
        public int age;


        public Employee(int id, String name, int age){
            this.id = id;
            this.name = name;
            this.age = age;
        }
        @Override
        public String toString(){
            return "Employee{" +
                    "id=" + id +
                    ", name=" + name + '\'' +
                    ", age=" + age +
                    "}";
        }
        @Override
        public int compareTo(Employee other){
            if (id > other.age)
                return 1;
            else if (id < other.age)
                return -1;
            else
                return 0;
        }
    }

    public void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(2, "Mark", 30));
        employees.add(new Employee(3, "Paul", 51));
        employees.add(new Employee(1, "Watson", 21));

        for (Employee employee : employees)
            System.out.println(employee);

        Collections.sort(employees);

        for (Employee employee : employees)
            System.out.println(employee);
    }
}


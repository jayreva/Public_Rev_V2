package demos;



public class demo68 {
    static class Employee{
        public int empId;
        public String name;
        public static String companyName = "Revature";

        public Employee(int empId, String name){
            this.empId = empId;
            this.name = name;
        }

        public void printInfo(){
            System.out.println("Id: "+ empId+ ", Name: "+ name+ ", Company Name: "+ companyName);
        }
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Mark");
        Employee emp2 = new Employee(2, "Paul");
        emp1.printInfo();
        emp2.printInfo();
        Employee.companyName = "ABC";
        emp1.printInfo();
        emp2.printInfo();
    }
}

package demos;



public class demo65 {
    static class Student {
        public int rollNumber;
        public String name;
        static public String schoolName = "High School";
    }

    public static void main(String[] args) {
        Student student1 = new Student();
        student1.rollNumber = 1;
        student1.name = "Mark";

        Student student2 = new Student();
        student2.rollNumber = 2;
        student2.name = "Paul";
    }
}

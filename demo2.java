package demos;

public class demo2 {
    public static void main(String[] args) {
        Student stu = new Student(){};
        stu.name = "Pam";
        System.out.println(stu.name);
    }
}

class Student {
    String name;
}
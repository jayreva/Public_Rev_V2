package demos;

class EmployeeException extends RuntimeException{

}

public class demo45 {
    public static void main(String[] args) {
        //throw new ArithmeticException();
        throw new EmployeeException();
    }
}

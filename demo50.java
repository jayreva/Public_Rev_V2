package demos;

public class demo50 {
    public static void main(String[] args) {
        try{
            doSomething();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void doSomething() throws Exception {
        doSomethingElse();
    }

    public static void doSomethingElse() throws Exception {
        doSomethingSomethingElse();
    }

    public static void doSomethingSomethingElse() throws Exception {
        throw new Exception();
    }
}

package demos;

class Test{
//    public Test(){
//        System.out.println("Constructor called..");
//    }

    int counter;

    public Test(int counter){
        this.counter = counter;
        System.out.println(this.counter);
    }

}

public class demo25 {
    public static void main(String[] args) {
        Test test = new Test(100);
    }
}

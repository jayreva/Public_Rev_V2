package demos;

class MultiThreadDemo extends Thread{
    @Override
    public void run(){
        super.run();
        System.out.println("thread is running...");
    }
}

public class demo113 {
    public static void main(String[] args) {
        MultiThreadDemo threadDemo = new MultiThreadDemo();
        threadDemo.start();
    }
}

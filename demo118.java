package demos;

class ThreadPriorityDemo extends Thread{
    @Override
    public void run(){
        System.out.println("running tread name is " + Thread.currentThread().getName());
        System.out.println("running thread priority is " + Thread.currentThread().getPriority());
    }
}

public class demo118 {
    public static void main(String[] args) {
        ThreadPriorityDemo t1 = new ThreadPriorityDemo();
        ThreadPriorityDemo t2 = new ThreadPriorityDemo();
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}

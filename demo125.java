package demos;

public class demo125 {
    public static void main(String[] args) {
        final String resource1 = "First resource";
        final String resource2 = "Second resource";

        Thread t1 = new Thread(){
            @Override
            public void run(){
                synchronized (resource1){
                    System.out.println("Thread 1: locked resource 1");
                    try{
                        Thread.sleep(500);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    synchronized (resource2){
                        System.out.println("Thread 1: locked resource 2");
                    }
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run(){
                synchronized (resource2){

                }
            }
        }

    }
}

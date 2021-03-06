package demos;

class ThreadJoinDemo extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 5; i++){
            try{
                sleep(500);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Thread name: " + Thread.currentThread().getName());
            System.out.println(i);
        }
    }

}

public class demo119 {
    public static void main(String[] args) {
        ThreadJoinDemo t1 = new ThreadJoinDemo();
        ThreadJoinDemo t2 = new ThreadJoinDemo();
        ThreadJoinDemo t3 = new ThreadJoinDemo();
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        t3.start();
    }
}

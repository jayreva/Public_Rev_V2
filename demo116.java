package demos;

class TestCallRun extends Thread{
    @Override
    public void run(){
        for(int i = 0; i<5; ){
            try{
                Thread.sleep(500);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

public class demo116 {
    public static void main(String[] args) {
        TestCallRun t1 = new TestCallRun();
        TestCallRun t2 = new TestCallRun();

    }
}

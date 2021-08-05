package demos;

//class Table{
//    public void printTable(int number){
//        for (int i = 0; i < 10; i++){
//            System.out.println(number + " X " + i + " = " + number * 1);
//            try{
//                Thread.sleep(500);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }
//    }
//}

class Table{
    synchronized public void printTable(int number){
        for (int i = 0; i < 10; i++){
            System.out.println(number + " X " + i + " = " + number * 1);
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class MyThread1 extends Thread{
    Table table;
    public MyThread1(Table table){
        this.table = table;
    }
    @Override
    public void run(){
        table.printTable(5);
    }
}

class MyThread2 extends Thread{
    Table table;

    public MyThread2(Table table){
        this.table = table;
    }
    @Override
    public void run(){
        table.printTable(500);
    }
}

public class demo121 {
    public static void main(String[] args) {
        Table table = new Table();
        MyThread1 t1 = new MyThread1(table);
        MyThread2 t2 = new MyThread2(table);
        t1.start();
        t2.start();

    }
}

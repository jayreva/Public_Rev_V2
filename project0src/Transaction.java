public class Transaction {

    private int rootAccountNum;
    private int targetAccountNum;
    private double amount;
    private int transactionNum;

    public Transaction(){}

    public Transaction(int rootAccountNum, int targetAccountNum, double amount, int transactionNum){

        this.rootAccountNum = rootAccountNum;
        this.targetAccountNum = targetAccountNum;
        this.amount = amount;
        this.transactionNum = transactionNum;

    }

    public int getRootAccountNum(){
        return rootAccountNum;
    }

    public void setRootAccountNum(int rootAccountNum){
        this.rootAccountNum = rootAccountNum;
    }

    public int getTargetAccountNum(){
        return targetAccountNum;
    }

    public void setTargetAccountNum(int targetAccountNum){
        this.targetAccountNum = targetAccountNum;
    }

    public double getAmount(){
        return amount;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }

    public int getTransactionNum() {return transactionNum;}

    public void setTransactionNum(int transactionNum) {this.transactionNum = transactionNum;}
}

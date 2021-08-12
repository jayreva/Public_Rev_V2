public class CustomerAccount{
    private long ssn;
    private int accountNum;
    private String name;
    private String password;
    private String email;
    private int pin;
    private double balance;


    public CustomerAccount(){}

    public CustomerAccount(long ssn, int accountNum, String name, String password, String email, int pin, double balance){
        this.ssn = ssn;
        this.accountNum = accountNum;
        this.name = name;
        this.password = password;
        this.email = email;
        this.pin = pin;
        this.balance = balance;
    }
    public long getSSN(){
        return ssn;
    }

    public void setSSN(long sssn){
        ssn = sssn;
    }

    public int getAccountNum(){
        return accountNum;
    }

    public void setAccountNum(int accountNumm){
        accountNum = accountNumm;
    }

    public String getName(){
        return name;
    }

    public void setName(String nam){
        name = nam;
    }

    public String getPassword() {return password;}

    public void setPassword(String passwor) {password = passwor;}

    public String getEmail(){
        return email;
    }

    public void setEmail(String emai){ email = emai;}

    public int getPin() {return pin;}

    public void setPin(int spin) {pin = spin;}

    public double getBalance() {return balance;}

    public void setBalance(double balanse) {balance = balanse;}
}

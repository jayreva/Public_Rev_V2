package demos;

public class demo84 {
    interface IBankAccount {

        boolean deposit(double amount);

        boolean withdraw(double amount);

        void getBalance();
    }

    class SavingAccount implements IBankAccount {

        private double balance;
        private double perDayLimit;

        @Override
        public boolean deposit(double amount) {
            balance += amount;
            return true;
        }

        @Override
        public boolean withdraw(double amount) {
            if (balance < amount) {
                System.out.println("Insufficient balance!");
                return false;
            }
            // limit 5000
            else if (perDayLimit + amount > 5000) {
                System.out.println("withdraw attempt failed");
                return false;
            } else {
                balance -= amount;
                perDayLimit += amount;
                System.out.println("Successfully withdraw: " + amount);
                return true;
            }
        }

        @Override
        public void getBalance() {
            System.out.println("Saving Account Balance" + balance);
        }
    }

    class CurrentAccount implements IBankAccount {

        private double balance;

        @Override
        public boolean deposit(double amount) {
            balance += amount;
            return true;
        }

        @Override
        public boolean withdraw(double amount) {
            if (balance < amount) {
                System.out.println("insufficient balance!");
                return false;
            } else {
                balance -= amount;
                System.out.println("successfully withdraw: " + amount);
                return true;
            }
        }

        @Override
        public void getBalance() {
            System.out.println("Current Account Balance" + balance);
        }
    }

    public void main(String[] args) {
        IBankAccount savingAccount = new SavingAccount();
        IBankAccount currentAccount = new CurrentAccount();

        savingAccount.deposit(1000);
        savingAccount.withdraw(1000);
        savingAccount.getBalance();

        currentAccount.deposit(5000);
        currentAccount.withdraw(6000);
        currentAccount.withdraw(2000);
        currentAccount.getBalance();
    }
}
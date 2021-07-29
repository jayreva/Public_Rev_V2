package demos;



public class demo46 {
    class InsufficientFundException extends Exception {
        public InsufficientFundException() {
            System.out.println("Insufficient amount requested");
        }
    }


    class BankAccount {
        private int balance = 0;
        private int accountNumber;

        public BankAccount(int accountNumber) {
            this.accountNumber = accountNumber;
        }

        public void deposit(int amount) {
            account.balance += amount;
            System.out.println("amount credited: " + amount);
        }

        public void withdrawl(int amount) throws InsufficientFundException {
            if (amount <= account.balance) {
                account.balance -= amount;
                System.out.println("amount debited: " + amount);
            } else
                throw new InsufficientFundException();
        }

        public int getBalance(BankAccount account) {
            return account.balance;
        }

        public int getAccountNumber(BankAccount account) {
            return account.accountNumber;
        }

        public void main(String[] args) {
            BankAccount account = new BankAccount(134);
            System.out.println(account.getBalance());
            account.deposit(5000);
            try {
                account.withdrawl(2000);
            } catch (InsufficientFundException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}

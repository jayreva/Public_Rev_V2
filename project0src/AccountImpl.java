import java.sql.*;
import java.util.*;

public class AccountImpl implements AccountBase {

    private static Statement statement = null;
    private static Connection connection = null;
    private static int inpPIN;
    private static double inpBal;

    public AccountImpl() {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void verifyUser(String email, String password) throws SQLException {
        String sql = "select Email, Password from Active_Accounts";
        this.connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String emaildb = resultSet.getString(1);
            String passworddb = resultSet.getString(2);
            if (emaildb.equals(email) && passworddb.equals(password)) {
                Main.validLogin = true;
                break;
            }
        }
        String sql2 = "select Email, Password from Employee_Accounts";
        //this.connection = ConnectionFactory.getConnection();
        //Statement statement = connection.createStatement();
        ResultSet resultSet2 = statement.executeQuery(sql2);
        while (resultSet2.next()) {
            String emaildbe = resultSet2.getString(1);
            String passworddbe = resultSet2.getString(2);
            if (emaildbe.equals(email) && passworddbe.equals(password)) {
                Main.validEmpLogin = true;
                break;
            }
        }
        if (Main.validLogin == false && Main.validEmpLogin == false)
            System.out.println("Incorrect email/password, try again");
    }

    @Override
    public void apply(long ssn, String name, String password, String email) throws SQLException {
        String sql = "insert into Pending_Accounts (SSN, Name, Password, Email) values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, ssn);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, password);
        preparedStatement.setString(4, email);
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Account Submitted!");
        } else
            System.out.println("Something went wrong");
    }

    @Override
    public List<CustomerAccount> viewAccounts(long ssn) throws SQLException {

        String sql = "select * from Active_Accounts where SSN = " + ssn;

        this.connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int accountNum = resultSet.getInt(2);
            String name = resultSet.getString(3);
            String password = resultSet.getString(4);
            int pin = resultSet.getInt(6);
            double balance = resultSet.getDouble(7);

            System.out.println("*************");
            System.out.println("Account Number = " + accountNum + " Name = " + name + " Balance= " + balance + " PIN = " + pin);
            System.out.println("*************");
        }
        return null;
    }


    @Override
    public void deposit(int accountNum, double amount, int pin) throws SQLException {
        String sql = "select Balance from Active_Accounts where AccountNum = " + accountNum + " and PIN = " + pin;
        //System.out.println(sql);
        double bal;
//        String sql = "select Balance from Active_Accounts where AccountNum = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setInt(1, accountNum);
        this.connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();

        try {
            bal = resultSet.getDouble(1);


            double finalBalance = bal + amount;

            String sql1 = "update Active_Accounts set Balance = " + finalBalance + " where accountNum = " + accountNum;
            //System.out.println(sql1);
            PreparedStatement preparedStatement = connection.prepareStatement(sql1);
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                System.out.println("Your new balance is $" + finalBalance);
                System.out.println("Account updated");
            } else
                System.out.println("Something went wrong, your balance is $" + finalBalance);
        } catch (SQLException e) {
            System.out.println("*************");
            System.out.println("Invalid Pin");
            System.out.println("*************");
        }
    }

    @Override
    public void deposit(int accountNum, double amount) throws SQLException {
        String sql = "select Balance from Active_Accounts where AccountNum = " + accountNum;
        //System.out.println(sql);
        double bal;
//        String sql = "select Balance from Active_Accounts where AccountNum = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setInt(1, accountNum);
        this.connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        bal = resultSet.getDouble(1);


        double finalBalance = bal + amount;

        String sql1 = "update Active_Accounts set Balance = " + finalBalance + " where accountNum = " + accountNum;
        //System.out.println(sql1);
        PreparedStatement preparedStatement = connection.prepareStatement(sql1);
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Your new balance is $" + finalBalance);
            System.out.println("Account updated");
        } else
            System.out.println("Something went wrong, your balance is $" + finalBalance);

    }

    @Override
    public void withdraw(int accountNum, double amount, int pin) throws SQLException {
        String sql = "select Balance from Active_Accounts where AccountNum = " + accountNum + " and PIN = " + pin;
        //System.out.println(sql);
        double bal;

        this.connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();

        try {
            bal = resultSet.getDouble(1);


            double finalBalance = bal - amount;
            if (finalBalance < 0) {
                System.out.println("Withdraw limit exceeded, transaction cancelled");
                Main.validTransfer = false;
            } else {
                Main.validTransfer = true;
                String sql1 = "update Active_Accounts set Balance = " + finalBalance + " where accountNum = " + accountNum;
                //System.out.println(sql1);
                PreparedStatement preparedStatement = connection.prepareStatement(sql1);

                int count = preparedStatement.executeUpdate();
                if (count > 0) {
                    System.out.println("Your new balance is $" + finalBalance);
                    System.out.println("Account updated");

                } else {
                    System.out.println("Something went wrong, your balance is $" + finalBalance);
                }
            }
        } catch (Exception e) {
            System.out.println("*************");
            System.out.println("Invalid PIN");
            System.out.println("*************");
        }
    }

    @Override
    public void withdraw(int accountNum, double amount) throws SQLException {
        String sql = "select Balance from Active_Accounts where AccountNum = " + accountNum;
        //System.out.println(sql);
        double bal;

        this.connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        bal = resultSet.getDouble(1);

        double finalBalance = bal - amount;
        if (finalBalance < 0) {
            System.out.println("Withdraw limit exceeded, transaction cancelled");
            Main.validTransfer = false;
        } else {
            Main.validTransfer = true;
            String sql1 = "update Active_Accounts set Balance = " + finalBalance + " where accountNum = " + accountNum;
            //System.out.println(sql1);
            PreparedStatement preparedStatement = connection.prepareStatement(sql1);

            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                System.out.println("Your new balance is $" + finalBalance);
                System.out.println("Account updated");

            } else {
                System.out.println("Something went wrong, your balance is $" + finalBalance);
            }
        }
    }

    @Override
    public void transferRequest(int rootAccountNum, int targetAccountNum, double amount, long ssn, int pin) throws SQLException {
        String sql2 = "select PIN from Active_Accounts where AccountNum = " + targetAccountNum;
        this.connection = ConnectionFactory.getConnection();
        Statement statement2 = connection.createStatement();

        ResultSet resultSet1 = statement2.executeQuery(sql2);
        resultSet1.next();
        int targetPIN = resultSet1.getInt(1);

        if (pin == targetPIN) {
            String sql1 = "insert into Pending_Transactions (RootAccountNum, TargetAccountNum, amount) values (" + rootAccountNum + ", " +
                    targetAccountNum + ", " + amount + ")";
            Connection conn = ConnectionFactory.getConnection();
            Statement statement1 = connection.createStatement();
            PreparedStatement preparedStatement = conn.prepareStatement(sql1);
            int count = preparedStatement.executeUpdate();
            if (count > 0)
                System.out.println("Pending Transactions updated");
            else
                System.out.println("Something went wrong");
        } else {
            String sql = "select SSN from Active_Accounts where AccountNum = " + rootAccountNum + " and PIN = " + pin;
            this.connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            try {
                long rootSSN = resultSet.getLong(1);
                if (ssn == rootSSN) {
                    transfer(rootAccountNum, targetAccountNum, amount);
                } else if (ssn == targetAccountNum) {
                    String sql1 = "insert into Pending_Transactions (RootAccountNum, TargetAccountNum, amount) values (" + rootAccountNum + ", " +
                            targetAccountNum + ", " + amount + ")";
                    Connection conn = ConnectionFactory.getConnection();
                    Statement statement1 = connection.createStatement();
                    PreparedStatement preparedStatement = conn.prepareStatement(sql1);
                    int count = preparedStatement.executeUpdate();
                    if (count > 0) {
                        System.out.println("Pending Transactions updated");
                    } else
                        System.out.println("Something went wrong");
                }
            } catch (Exception e) {
                System.out.println("Invalid PIN");
            }
        }
    }

    @Override
    public void transfer(int rootAccountNum, int targetAccountNum, double amount) throws SQLException {
        System.out.println("Account number " + rootAccountNum + ":");
        withdraw(rootAccountNum, amount);
        if (Main.validTransfer == true) {
            System.out.println("Account number " + targetAccountNum + ":");
            deposit(targetAccountNum, amount);
            String sql1 = "insert into Pending_Transactions (RootAccountNum, TargetAccountNum, Amount, TransferID) values (" +
                    rootAccountNum + ", " + targetAccountNum + ", " + amount + ")";


        } else
            System.out.println("Transfer failed, insufficient funds");
    }

    @Override
    public void transfer(int transactionNum) throws SQLException {
        String sql = "select * from Pending_Transactions where TransferID = " + transactionNum;
        this.connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        Transaction transaction = new Transaction();

        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int rootAcc = resultSet.getInt(1);
            transaction.setRootAccountNum(rootAcc);
            int targetAcc = resultSet.getInt(2);
            transaction.setTargetAccountNum(targetAcc);
            double amount = resultSet.getDouble(3);
            transaction.setAmount(amount);
            transaction.setTransactionNum(transactionNum);
            //System.out.println("Transfer $" + amount + " from account number " + rootAcc + " to account number " + targetAcc + ". " +
            //       "Transaction number " + transactionNum);
        }
        String sql1 = "select PIN, Balance from Active_Accounts where AccountNum = " + transaction.getRootAccountNum();

        this.connection = ConnectionFactory.getConnection();
        Statement statement1 = connection.createStatement();

        ResultSet rs = statement1.executeQuery(sql1);

        while (rs.next()) {
            inpPIN = rs.getInt(1);
            inpBal = rs.getInt(2);
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your PIN");
        int pin = scan.nextInt();
        scan.nextLine();
        if (pin == inpPIN) {
            System.out.println("Account number " + transaction.getRootAccountNum() + ":");
            withdraw(transaction.getRootAccountNum(), transaction.getAmount());
            if (Main.validTransfer == true) {
                System.out.println("Account number " + transaction.getTargetAccountNum() + ":");
                deposit(transaction.getTargetAccountNum(), transaction.getAmount());
                String sql2 = "insert into Transaction_History (RootAccountNum, TargetAccountNum, Amount, TransferID) values (" +
                        transaction.getRootAccountNum() + ", " + transaction.getTargetAccountNum() + ", " + transaction.getAmount() +
                        ", " + transaction.getTransactionNum() + ")";
                connection = ConnectionFactory.getConnection();

                deleteTransaction(transaction.getTransactionNum());
                PreparedStatement preparedStatement = connection.prepareStatement(sql2);
                int count = preparedStatement.executeUpdate();
                if(count > 0){
                    System.out.println("Transaction history updated");
                }
                else
                    System.out.println("Something went wrong");

            } else
                System.out.println("Transfer failed, insufficient funds");
        } else
            System.out.println("Invalid PIN");
    }

    @Override
    public void viewPersonalTransfers(String email) throws SQLException {
        boolean validInp = false;
        Scanner scan = new Scanner(System.in);
        String sql1 = "select AccountNum from Active_Accounts where email = '" + email + "'";
        //System.out.println(sql1);
        this.connection = ConnectionFactory.getConnection();
        Statement statement2 = connection.createStatement();
        ResultSet resultSet = statement2.executeQuery(sql1);
        List<Integer> transNum = new ArrayList<>();
        List<Integer> accountList = new ArrayList<>();
        Iterator value = accountList.iterator();

        //System.out.println(resultSet.getArray(1));

        while (resultSet.next()) {
            accountList.add(resultSet.getInt(1));
            System.out.println("Account Number " + resultSet.getInt(1));
        }
        System.out.println("Account numbers with pending transactions");
        for (int i = 0; !accountList.isEmpty(); i++) {
            System.out.println(accountList.get(0));
            String sql = "select * from Pending_Transactions where RootAccountNum = " + accountList.get(0);
            System.out.println(sql);
            Statement statement = connection.createStatement();
            ResultSet resultSet1 = statement.executeQuery(sql);
//            List<Integer> transNum = new ArrayList<>();
            while (resultSet1.next()) {
                int rootAcc = resultSet1.getInt(1);
                //transaction.setRootAccountNum(rootAcc);
                int targetAcc = resultSet1.getInt(2);
                //transaction.setTargetAccountNum(targetAcc);
                double amount = resultSet1.getDouble(3);
                //transaction.setAmount(amount);
                int transactionNum = resultSet1.getInt(4);
                //transaction.setTransactionNum(transactionNum);
                System.out.println("Transfer $" + amount + " from account number " + rootAcc + " to account number " + targetAcc + ". " +
                        "Transaction number " + transactionNum);

                transNum.add(resultSet1.getInt(4));
            }
            accountList.remove(0);
        }


//        ResultSet resultSet1 = statement.executeQuery(sql);
//        System.out.println("*************");
//        while (resultSet1.next()) {
//            int rootAcc = resultSet1.getInt(1);
//            //transaction.setRootAccountNum(rootAcc);
//            int targetAcc = resultSet1.getInt(2);
//            //transaction.setTargetAccountNum(targetAcc);
//            double amount = resultSet1.getDouble(3);
//            //transaction.setAmount(amount);
//            int transactionNum = resultSet1.getInt(4);
//            //transaction.setTransactionNum(transactionNum);
//            System.out.println("Transfer $" + amount + " from account number " + rootAcc + " to account number " + targetAcc + ". " +
//                    "Transaction number " + transactionNum);
//        }
        System.out.println("*************");
        if (resultSet == null) {
            System.out.println("No pending transactions");
        } else {
            System.out.println("Select transaction number to interact with");
            int tran = scan.nextInt();
            scan.nextLine();
            //String sql1 = "select * from ";
            while (!validInp) {
                System.out.println("Enter \"yes\" to accept transfer, \"no\" to reject");
                String selectTran = scan.nextLine();

                if (selectTran.equalsIgnoreCase("yes")) {
                    transfer(tran);
                    deleteTransaction(tran);
                    validInp = true;
                } else if (selectTran.equalsIgnoreCase("no")) {
                    deleteTransaction(tran);
                    validInp = true;
                } else {
                    System.out.println("Enter a valid input please, yes or no");
                    validInp = false;
                }

            }
        }
    }

    @Override
    public void deleteTransaction(int transactionNum) throws SQLException {
        String sql = "delete from Pending_Transactions where TransferID = " + transactionNum;
        this.connection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Transaction removed");
        } else
            System.out.println("Something went wrong");
    }

    @Override
    public void approve() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String sql = "select * from Pending_Accounts";
        this.connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        CustomerAccount newCustomer = new CustomerAccount();
        while (resultSet.next()) {
            long ssn = resultSet.getLong(1);
            String name = resultSet.getString(2);
            String password = resultSet.getString(3);
            String email = resultSet.getString(4);
//            newCustomer.setSSN(ssn);
//            newCustomer.setName(name);
//            newCustomer.setPassword(password);
//            newCustomer.setEmail(email);

            System.out.println("SSN = " + ssn + " Name = " + name + " Password = " + " Email = " + email);
        }
        System.out.println("Choose a SSN to approve");
        long aprSSN = scanner.nextLong();
        scanner.nextLine();
        String sql1 = "select * from Pending_Accounts where SSN = " + aprSSN;
        this.connection = ConnectionFactory.getConnection();
        Statement statement1 = connection.createStatement();
        ResultSet resultSet1 = statement1.executeQuery(sql1);

        while (resultSet1.next()) {
            long ssn = resultSet1.getLong(1);
            String name = resultSet1.getString(2);
            String password = resultSet1.getString(3);
            String email = resultSet1.getString(4);
            newCustomer.setSSN(ssn);
            newCustomer.setName(name);
            newCustomer.setPassword(password);
            newCustomer.setEmail(email);
            Random rand = new Random();
            int AccountNum = rand.nextInt(1_000_000);
            newCustomer.setAccountNum(AccountNum);
            System.out.println("SSN = " + ssn + " Name = " + name + " Password = " + " Email = " + email);
        }
        System.out.println("\"Employee\" or \"Customer\" account?");
        String accType = scanner.nextLine();
        if (accType.equalsIgnoreCase("Customer")) {
            System.out.println("Enter the new user's PIN");
            boolean validPIN = false;
            int newPIN = -1;
            while (!validPIN) {
                if (newPIN > 10000) {
                    validPIN = false;
                } else if (newPIN < 0) {
                    newPIN = scanner.nextInt();
                    scanner.nextLine();
                    validPIN = false;
                } else {
                    validPIN = true;
                    NewPIN.setNewPIN(newPIN);
                }
            }
            System.out.println("Stating balance? (\"yes\" or \"no\")");
            String sb = scanner.nextLine();
            if (sb.equalsIgnoreCase("yes")) {
                System.out.println("Enter starting balance");
                newCustomer.setBalance(scanner.nextDouble());
                scanner.nextLine();
            } else if (sb.equalsIgnoreCase("no")) {
                newCustomer.setBalance(0.0);
            } else {
                System.out.println("Invalid answer, balance will be zero");
                newCustomer.setBalance(0.0);
            }
            String sql2 = "insert into Active_Accounts (SSN, AccountNum, Name, Password, Email, Pin, Balance) values (" + newCustomer.getSSN() +
                    ", " + newCustomer.getAccountNum() + ", '" + newCustomer.getName() + "', '" + newCustomer.getPassword() + "', '" +
                    newCustomer.getEmail() + "', " + NewPIN.getNewPIN() + ", " + newCustomer.getBalance() + ")";
            PreparedStatement preparedStatement = connection.prepareStatement(sql2);
            System.out.println(sql2);
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                System.out.println("Account activated");
            } else
                System.out.println("Something went wrong");
            deletePending(aprSSN);
        } else if (accType.equalsIgnoreCase("Employee")) {
            Random rand = new Random();
            int EmployeeNum = rand.nextInt(1_000_000);
            String sql3 = "insert into Employee_Accounts (EmployeeNum, Password, Name, Email) values (" + EmployeeNum +
                    ", '" + newCustomer.getPassword() + "', '" + newCustomer.getName() + "', '" + newCustomer.getEmail() + "')";
            this.connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql3);
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                System.out.println("Employee account added");
            } else
                System.out.println("Something went wrong");
            deletePending(aprSSN);
        } else
            System.out.println("Invalid input");
    }

    public static class NewPIN {
        private static int newPIN;

        //public int newPIN;
        public static int getNewPIN() {
            return newPIN;
        }

        public static void setNewPIN(int newtPIN) {
            newPIN = newtPIN;
        }
    }

    @Override
    public void deletePending(long ssn) throws SQLException {
        String sql = "delete from Pending_Accounts where SSN = " + ssn;
        this.connection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Pending account removed");
        } else
            System.out.println("Something went wrong");
    }

    @Override
    public List<CustomerAccount> getAccounts() throws SQLException {
        String sql = "select * from Active_Accounts";
        this.connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            long ssn = resultSet.getLong(1);
            int accountNum = resultSet.getInt(2);
            String name = resultSet.getString(3);
            String password = resultSet.getString(4);
            String email = resultSet.getString(5);
            int pin = resultSet.getInt(6);
            double balance = resultSet.getDouble(7);

            System.out.println("SSN = " + ssn + " Account Number = " + accountNum + " Name = " + name + " Password = " +
                    password + " Email = " + email + " PIN = " + pin + "Balance = " + balance);
        }
        return null;
    }

    @Override
    public CustomerAccount accountByNum(int accountNum) throws SQLException {
        String sql = "select * from Active_Accounts where AccountNum = " + accountNum;
        this.connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            long ssn = resultSet.getLong(1);
            int accountNumb = resultSet.getInt(2);
            String name = resultSet.getString(3);
            String password = resultSet.getString(4);
            String email = resultSet.getString(5);
            int pin = resultSet.getInt(6);
            double balance = resultSet.getDouble(7);

            System.out.println("SSN = " + ssn + " Account Number = " + accountNumb + " Name = " + name + " Password = " +
                    password + " Email = " + email + " PIN = " + pin + "Balance = " + balance);
        }
        return null;
    }

    @Override
    public EmployeeAccount empAccountByNum(int accountNum) throws SQLException {
        String sql = "select * from Employee_Accounts where EmployeeNum = " + accountNum;
        this.connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        EmployeeAccount employeeAccount = new EmployeeAccount();
        while (resultSet.next()) {
            int empNum = resultSet.getInt(1);
            String password = resultSet.getString(2);
            String name = resultSet.getString(3);
            String email = resultSet.getString(4);
            employeeAccount.setEmployeeNum(empNum);
            employeeAccount.setPassword(password);
            employeeAccount.setName(name);
            employeeAccount.setEmail(email);

            System.out.println("Account Number = " + empNum + " Name = " + name + " Password = " +
                    password + " Email = " + email);
        }
        return null;
    }

    @Override
    public CustomerAccount accountBySSN(long ssn) throws SQLException {
        String sql = "select * from Active_Accounts where SSN = " + ssn;
        this.connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            long ssnn = resultSet.getLong(1);
            int accountNum = resultSet.getInt(2);
            String name = resultSet.getString(3);
            String password = resultSet.getString(4);
            String email = resultSet.getString(5);
            int pin = resultSet.getInt(6);
            double balance = resultSet.getDouble(7);

            System.out.println("SSN = " + ssnn + " Account Number = " + accountNum + " Name = " + name + " Password = " +
                    password + " Email = " + email + " PIN = " + pin + "Balance = " + balance);
        }
        return null;
    }


    @Override
    public void transTable() throws SQLException {
        String sql = "select * from Transaction_History";
        this.connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int rootAccountNum = resultSet.getInt(1);
            int targetAccountNum = resultSet.getInt(2);
            double amount = resultSet.getDouble(3);
            int transNum = resultSet.getInt(4);
            System.out.println("Transaction number " + transNum + ", $" + amount + " was transferred from account " + rootAccountNum + " to " + targetAccountNum );
        }
    }
}

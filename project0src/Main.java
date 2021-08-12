import java.sql.*;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);


    static int option = 0;
    static int option1 = 0;
    static int option2 = 0;
    static boolean login = false;
    static boolean correct = false;
    static boolean validLogin = false;
    static boolean validEmpLogin = false;
    static long ssn;
    static int accountNum;
    static boolean validTransfer = true;
    private static Connection co = null;

    public static void main(String[] args) throws SQLException {

        String password = null;
        String email = null;
        int pin;
        String name;



        AccountBase base = AccountFactory.getAccountBase();

        System.out.println("*************");
        System.out.println("Select from options below");
        System.out.println("*************");
        System.out.println("1. Login");
        System.out.println("2. Apply for an Account");
        System.out.println("3. Exit Program");
        System.out.println("*************");
        option1 = scanner.nextInt();
        scanner.nextLine();

        if (option1 == 1) {
            while ((validLogin || validEmpLogin) == false) {
                System.out.println("Enter Email");
                email = scanner.nextLine();
                System.out.println("Enter Password");
                password = scanner.nextLine();
                base.verifyUser(email, password);
            }
        }
        else if (option1 == 2){
            System.out.println("Enter Name");
            name = scanner.nextLine();
            out:
            while (correct == false){
                System.out.println("Enter Password");
                password = scanner.nextLine();
                System.out.println("Enter Password Again");
                String password1 = scanner.nextLine();
                if (! password.equals(password1)) {
                    System.out.println("Your passwords do not match");
                    continue out;
                }
                else
                    correct = true;
            }

            System.out.println("Enter Email");
            email = scanner.nextLine();
            System.out.println("Enter SSN");
            ssn = scanner.nextLong();
            scanner.nextLine();
            base.apply(ssn, name, password, email);
            System.out.println("Thank you, your account will be reviewed.");
        }
        else if (option1 == 3)
            System.exit(10);
        if(validLogin) {
            while (option != 6) {
                String sql1 = "select SSN from Active_Accounts where Email = '" + email + "'";
                Connection conn = ConnectionFactory.getConnection();
                Statement statement1 = conn.createStatement();
                //System.out.println(sql1);
                ResultSet retrvSSN = statement1.executeQuery(sql1);
                retrvSSN.next();
                ssn = retrvSSN.getLong(1);

//                String sqlGetAcc = "select * from Active_Accounts where SSN = " + ssn;
//                Connection c = ConnectionFactory.getConnection();
//                Statement s = c.createStatement();
//                ResultSet accStore = s.executeQuery(sqlGetAcc);
//                CustomerAccount[] userAccounts = new CustomerAccount[0];
//                while (accStore.next()){
//                    int i = 0;
//                    userAccounts[i] = new CustomerAccount();
//                    int accountNum = accStore.getInt(2);
//                    String accName = accStore.getString(3);
//                    String accPassword = accStore.getString(4);
//                    String accEmail = accStore.getString(5);
//                    int accPIN = accStore.getInt(6);
//                    double accBalance = accStore.getDouble(7);
//                    userAccounts[i].setSSN(ssn);
//                    userAccounts[i].setAccountNum(accountNum);
//                    userAccounts[i].setName(accName);
//                    userAccounts[i].setPassword(accPassword);
//                    userAccounts[i].setEmail(accEmail);
//                    userAccounts[i].setPin(accPIN);
//                    userAccounts[i].setBalance(accBalance);
//                    System.out.println(userAccounts[i]);
//                }

                //System.out.println("SSN = " + ssn);

                System.out.println("*************");
                System.out.println("Select from options below");
                System.out.println("*************");
                System.out.println("1. View accounts");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Transfer");
                System.out.println("5. View Transfers");
                System.out.println("6. Exit");
                System.out.println("*************");

                System.out.println("Enter your option: ");
                option = scanner.nextInt();
                scanner.nextLine();



                switch (option) {
                    case 1: {
                        //view

                        base.viewAccounts(ssn);

                        break;
                    }
                    case 2: {
                        //deposit
                        boolean validDeposit = false;
                        System.out.println("Please enter the account number into which you would like to deposit");
                        accountNum = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Please enter your PIN");
                        pin = scanner.nextInt();
                        scanner.nextLine();
                        while (!validDeposit) {
                            System.out.println("Please enter the amount you would like to deposit");
                            double amount = scanner.nextDouble();
                            scanner.nextLine();
                            if (amount < 0) {
                                System.out.println("Please enter a positive value");

                            } else{
                                validDeposit = true;
                            base.deposit(accountNum, amount, pin);
                        }
                    }
                        break;
                    }
                    case 3: {
                        //withdraw
                        boolean validWithdrawal = false;
                        System.out.println("Please enter the account number from which you would like to withdraw");
                        accountNum = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Please enter your PIN");
                        pin = scanner.nextInt();
                        scanner.nextLine();
                        while (!validWithdrawal) {
                            System.out.println("Please enter the amount you would like to withdraw");
                            double amount = scanner.nextDouble();
                            scanner.nextLine();
                            if (amount < 0) {
                                System.out.println("Please enter a positive value");
                            } else{
                                validWithdrawal = true;
                            base.withdraw(accountNum, amount, pin);
                            }
                    }
                            break;

                    }
                    case 4: {
                        //transfer
                        boolean validTransfer = false;
                        System.out.println("Enter the account you would like to transfer from (withdraw)");
                        int rootAccountNum = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter the account you would like to transfer to (deposit)");
                        int targetAccountNum = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Please enter your PIN");
                        pin = scanner.nextInt();
                        scanner.nextLine();
//                        System.out.println("Enter the amount you would like to transfer");
//                        double amount = scanner.nextDouble();
//                        scanner.nextLine();
                        while (!validTransfer) {
                            System.out.println("Please enter the amount you would like to transfer");
                            double amount = scanner.nextDouble();
                            scanner.nextLine();
                            if (amount < 0) {
                                System.out.println("Please enter a positive value");
                            } else{
                                base.transferRequest(rootAccountNum, targetAccountNum, amount, ssn, pin);
                                validTransfer = true;
                            }
                        }
                        break;
                    }
                    case 5: {
                        //System.out.println("Enter your account number");
                        //int accountNumber = scanner.nextInt();
                        //scanner.nextLine();
                        Transaction transaction = new Transaction();
                        base.viewPersonalTransfers(email);
                        boolean validInp = false;
                        String sql3 = "select ";

//                        while (!validInp) {
//                            System.out.println("Enter \"yes\" to accept transfer, \"not\" to reject");
//                            String tran = scanner.nextLine();
//
//                            if (tran.equalsIgnoreCase("yes")) {
//                                base.transfer(accountNumber, );
//                            } else if (tran.equalsIgnoreCase("no")) {
//                                String sql2 = "delete from Pending_Transfers where targetAccountNum = " + accountNumber;
//                                PreparedStatement preparedStatement = co.prepareStatement(sql2);
//                                int count = preparedStatement.executeUpdate();
//                                if(count > 0){
//                                    System.out.println("Transfer deleted");
//                                }
//                                else
//                                    System.out.println("Something went wrong");
//                            } else{
//                                System.out.println("Enter a valid input please, yes or no");
//
//                            }
//
//                        }
                    }
                }
            }
        }
        else if (validEmpLogin) {
            while (option2 != 4) {
                System.out.println("*************");
                System.out.println("Select from options below");
                System.out.println("*************");
                System.out.println("1. View accounts");
                System.out.println("2. View pending accounts");
                System.out.println("3. View transactions");
                System.out.println("4. Exit");
                System.out.println("*************");

                System.out.println("Enter your option: ");
                option2 = scanner.nextInt();
                scanner.nextLine();

                switch (option2) {
                    case 1: {
                        // view
                        int option3 = 0;
                        while (option3 != 5){
                            System.out.println("*************");
                            System.out.println("Select from options below");
                            System.out.println("*************");
                            System.out.println("1. View all accounts");
                            System.out.println("2. View customer accounts by number");
                            System.out.println("3. View employee accounts by number");
                            System.out.println("4. View accounts by SSN");
                            System.out.println("5. Exit");
                            System.out.println("*************");

                            System.out.println("Enter your option: ");
                            option3 = scanner.nextInt();
                            scanner.nextLine();

                            switch (option3){
                                case 1:{
                                    base.getAccounts();
                                    break;
                                }
                                case 2:{
                                    System.out.println("Enter account number");
                                    int actn = scanner.nextInt();
                                    scanner.nextLine();
                                    base.accountByNum(actn);
                                    break;
                                }
                                case 3:{
                                    System.out.println("Enter employee number");
                                    int eactn = scanner.nextInt();
                                    scanner.nextLine();
                                    base.empAccountByNum(eactn);
                                    break;
                                }
                                case 4:{
                                    System.out.println("Enter SSN");
                                    long ssnn = scanner.nextLong();
                                    scanner.nextLine();
                                    base.accountBySSN(ssnn);
                                    break;
                                }
                            }
                        }
                    }
                    case 2: {
                        // View pendings
                        base.approve();
                        break;
                    }
                    case 3: {
                        base.transTable();
                    }
                }
            }
        }
    }
}
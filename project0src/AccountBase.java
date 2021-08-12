import java.sql.SQLException;
import java.util.List;

public interface AccountBase {
    void verifyUser(String email, String password) throws SQLException;
    void apply(long ssn, String name, String password, String email) throws SQLException;
    List <CustomerAccount> viewAccounts(long ssn) throws SQLException;
    void deposit(int accountNum, double amount, int pin) throws SQLException;
    void deposit(int accountNum, double amount) throws SQLException;
    void withdraw(int accountNum, double amount, int pin) throws SQLException;
    void withdraw(int accountNum, double amount) throws SQLException;
    void approve() throws SQLException;
    List <CustomerAccount> getAccounts() throws SQLException;
    CustomerAccount accountByNum(int accountNum) throws SQLException;
    CustomerAccount accountBySSN(long ssn) throws SQLException;
    EmployeeAccount empAccountByNum(int employeeNum) throws SQLException;
    void transfer(int rootAccountNum, int targetAccountNum, double amount) throws SQLException;
    void transfer(int transactionNum) throws SQLException;
    void transferRequest(int rootAccountNum, int targetAccountNum, double amount, long ssn, int pin) throws SQLException;
    void viewPersonalTransfers(String email) throws SQLException;
    void deleteTransaction(int transactionNum) throws SQLException;
    void deletePending(long ssn) throws SQLException;
    void transTable()throws SQLException;


}

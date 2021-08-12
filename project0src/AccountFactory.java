import java.sql.SQLException;

public class AccountFactory {
    private static AccountBase base;

    private AccountFactory(){}

    public static AccountBase getAccountBase() throws SQLException {
        if(base == null){
            base = new AccountImpl();
        }
        return base;
    }
}

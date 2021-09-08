package DAOFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

    private static Connection connection = null;

    private ConnectionFactory() {};

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.cj.jdbc.Driver");
		if(connection == null) {
			String url = "jdbc:mysql://mysqlproj1.cj0u0pkpfpby.us-east-2.rds.amazonaws.com:3306/reimbursements";
            String username = "admin";
            String password = "project1";
			connection = DriverManager.getConnection(url, username, password);
		}
		
		return connection;
	}
}

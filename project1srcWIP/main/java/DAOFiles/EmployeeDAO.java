package DAOFiles;

public interface EmployeeDAO {
	void verifyUser(String email, String password);
	void viewTickets(String email);
	void addTicket(String email, double amount, String type, String description);
	void viewAllTickets();
	void viewAllPendings();
	void viewAllApproved();
	void viewAllRejected();
}

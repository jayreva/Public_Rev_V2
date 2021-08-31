package DAOFiles;

public class EmployeeFactory {
	private static EmployeeDAO dao;

    private EmployeeFactory(){}

    public static EmployeeDAO getEmployeeBase() {
        if(dao == null){
            dao = new EmployeeImpl();
        }
        return dao;
    }
}

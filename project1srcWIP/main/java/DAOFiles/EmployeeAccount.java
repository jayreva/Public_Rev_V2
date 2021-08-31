package DAOFiles;

public class EmployeeAccount {
	private String name;
    private String password;
    private String email;
    
    public EmployeeAccount(){}
    
    public EmployeeAccount(String password, String name, String email){
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}
}

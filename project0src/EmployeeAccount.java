public class EmployeeAccount {
    private int employeeNum;
    private String name;
    private String password;
    private String email;

    public EmployeeAccount(){}

    public EmployeeAccount(int employeeNum, String password, String name, String email){
        this.employeeNum = employeeNum;
        this.name = name;
        this.password = password;
        this.email = email;
    }
    public int getEmployeeNum(){
        return employeeNum;
    }

    public void setEmployeeNum(int employeeNum){
        this.employeeNum = employeeNum;
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



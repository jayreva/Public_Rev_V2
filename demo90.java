package demos;

public class demo90 {
    interface ICustomer{

    }
    class User{

    }

    class Customer implements ICustomer{

    }
    public void main(String[] args) {
        Customer customer = new Customer();
        //ICustomer iCustomer = new ICustomer();
        ICustomer iCustomer = new Customer();
        //ICustomer iCustomer = new User();
    }
}

package demos;

public class demo91 {
    interface DB{
        void connection();
        interface MySQL{

        }

        interface MongoDB{

        }
    }
    class MyApp implements DB.MongoDB{

    }
}

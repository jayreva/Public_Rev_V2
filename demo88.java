package demos;

public class demo88 {
    interface X{
        void print();
        interface Y{
            void display();
        }
    }

    class Z implements X, X.Y{

        @Override
        public void print() {

        }

        @Override
        public void display() {

        }
    }

    public static void main(String[] args) {

    }
}

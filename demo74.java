package demos;

public class demo74 {
    class Bank{
        public int getRateOfInterest(){
            return 0;
        }
    }

    class BankA extends Bank{
        public int getRateOfInterest(){
            return 7;
        }
    }

    class BankB extends Bank{
        @Override
        public int getRateOfInterest(){
            return 8;
        }
    }

    class BankC extends Bank{
        @Override
        public int getRateOfInterest(){
            return 8;
        }
    }

    public void main(String[] args) {
        BankA bankA = new BankA();
        BankB bankB = new BankB();

        System.out.println(bankA.getRateOfInterest());
        System.out.println(bankB.getRateOfInterest());
    }
}

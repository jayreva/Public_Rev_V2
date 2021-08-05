package demos;

public class demo143 {
    class Calculator2<T>{
        public <T> boolean areEqual(T a , T b){
            if(a.equals(b))
                return true;
            else
                return false;
        }
    }

    public void main(String[] args) {
        Calculator2 <String> cal = new Calculator2();
        cal.areEqual("A", "B");

        Calculator2<Integer> cal2 = new Calculator2();
        cal2.areEqual(10, 20);
    }
}

package demos;

public class demo48 {
    public static void main(String[] args) {
        try{
            int c = 10/5;
            System.out.println(c);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Case 1: finally called");
        }

        try {
            int c = 20/0;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Case 2: finally called");
        }

        try {
            int c = 10/0;
            System.out.println(c);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Case 3: finally called");
        }
    }
}

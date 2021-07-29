package demos;

public class demo12 {
    public static void main(String[] args) {

        int score = 78;

        if(score >= 90)
            System.out.println("A Grade");
        else if(score < 90 && score > 75)
            System.out.println("B Grade");
        else if(score < 80 && score > 70)
            System.out.println("C grade");
        else if (score < 70 && score > 60)
            System.out.println("D grade");
        else
            System.out.println("F grade");

    }
}

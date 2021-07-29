package demos;

class Book {
    public String title;
    public String author;
    public int price;

    public void printInfo() {
        System.out.println("Book: Title =" + title + ", Author =" + author + ", Price =" + price);
    }
}

public class demo21 {
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.title = "Java";
        book1.author = "Bill Bo";
        book1.price = 100;

        Book book2 = new Book();
        book2.title = "Angular";
        book2.author = "Mike Mo";
        book2.price = 200;

        book1.printInfo();
        book2.printInfo();
    }
}

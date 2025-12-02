package entity;

public class Book extends Product {
    private String author;
    private String publisher;

    public Book(int id, String name, double price, String category, int quantity, float discount,
                String author, String publisher) {
        super(id, name, price, category, quantity, discount);
        this.author = author;
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}

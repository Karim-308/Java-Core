package lab9.model;


public class Book extends LibraryItem {

    private String author;
    private Long ISBN;

    public Book(int id, String title, int stock, String publisher, String author, Long ISBN) {
        super(id, title, stock, publisher);
        this.author = author;
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getISBN() {
        return ISBN;
    }

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String getItemDetails() {
        return "Book (ID=" + id + ", Title=" + title + ", Author=" + author + ", Publisher=" + publisher + ", Stock="
                + stock + ", ISBN=" + ISBN + ")";
    }
}
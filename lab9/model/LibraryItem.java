
package lab9.model;

public abstract class LibraryItem {

    protected int id;
    protected String title;
    protected int stock;
    protected String publisher;

    public LibraryItem(int id, String title, int stock, String publisher) {
        this.id = id;
        this.title = title;
        this.stock = stock;
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public abstract String getItemDetails();
}

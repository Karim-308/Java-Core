package lab9.model;

public class Magazine extends LibraryItem{

    private int Version;

    public Magazine(int id, String title, int stock, String publisher, int Version) {
        super(id, title, stock, publisher);
        this.Version = Version;
    }

    public int getVersion() {
        return Version;
    }

    public void setAuthor(int Version) {
        this.Version = Version;
    }

    @Override
    public String getItemDetails() {
        return "Magazine (ID=" + id + ", Title=" + title + ", Version=" + Version + ", Publisher=" + publisher + ", Stock="
                + stock + ")";
    }
}

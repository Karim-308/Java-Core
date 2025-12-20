
package lab9.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import lab9.exception.ItemNotAvailableForClientException;
import lab9.exception.MaxBorrowLimitException;

public class Client {

    private int id;
    private String name;
    private String email;

    private Map<LibraryItem, LocalDate> borrowedItems;

    public static final int MAX_BORROW_LIMIT = 3;

    public static final int BORROW_DAYS = 14;

    public Client(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.borrowedItems = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<LibraryItem, LocalDate> getBorrowedItems() {
        return borrowedItems;
    }

    public boolean canBorrow() {
        return this.getBorrowedCount() < MAX_BORROW_LIMIT;
    }

    public int getBorrowedCount() {
        return borrowedItems.size();
    }

    public void borrowItem(LibraryItem item) throws MaxBorrowLimitException, ItemNotAvailableForClientException {
        if (hasBorrowed(item)) {
            throw new ItemNotAvailableForClientException(
                    "Client " + name + " has already borrowed item: " + item.getTitle());
        }
        if (!canBorrow()) {
            throw new MaxBorrowLimitException(
                    "Client " + name + " has reached max borrow limit (" + MAX_BORROW_LIMIT + " items)!");
        }
        // Due date = today + 14 days
        LocalDate dueDate = LocalDate.now().plusDays(BORROW_DAYS);
        borrowedItems.put(item, dueDate);
    }

    public void returnItem(LibraryItem item) {
        if (hasBorrowed(item)) borrowedItems.remove(item); 
        else System.out.println("Client "+this.name+  " didn't borrow "+ item.title);
    }

    public boolean hasBorrowed(LibraryItem item) {
        return borrowedItems.containsKey(item);
    }

    public String getClientDetails() {
        return "Client (ID=" + id + ", Name=" + name + ", Email=" + email + ", Borrowed=" + borrowedItems.size() + "/"
                + MAX_BORROW_LIMIT + ")";
    }

    public void displayBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("No borrowed items.");
            return;
        }
        System.out.println("Borrowed items for " + name + ":");
        for (Map.Entry<LibraryItem, LocalDate> entry : borrowedItems.entrySet()) {
            System.out.println("  -> " + entry.getKey().getTitle() + " (To be return before: " + entry.getValue() + ")");
        }
    }
}

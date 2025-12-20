package lab9;

import lab9.model.*;
import lab9.exception.*;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book(1, "c++", 3, "Karim company", "Karim Ibrahim", 545411114L);
        Book book2 = new Book(2, "Java", 2, "Ahmed company", "Ahmed Raouf", 11111111L);
        Book book3 = new Book(3, "Database", 1, "Mina company", "Stanford books", 80808080L);

        Magazine mag1 = new Magazine(4, "Technology", 5, "Vega", 15);
        Magazine mag2 = new Magazine(5, "Science", 2, "MIT", 30);

        library.addItem(book1);
        library.addItem(book2);
        library.addItem(book3);
        library.addItem(mag1);
        library.addItem(mag2);
        library.displayAllItems();

        Client client1 = new Client(1, "Mazen", "mazmax@gmail.com");
        Client client2 = new Client(2, "Lobna ghazal", "lobna@hotmail.com");

        library.addClient(client1);
        library.addClient(client2);

        library.displayAllClients();

        try {
            System.out.println();
            library.borrowItem(1, 1);
            library.borrowItem(1, 2);
            library.borrowItem(1, 4);

            System.out.println();
            library.displayClientBorrowedItems(1);

        } catch (ItemNotFoundException | MaxBorrowLimitException | ItemNotAvailableForClientException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println();
            library.borrowItem(1, 1); // same book again
            library.displayClientBorrowedItems(1);

        } catch (ItemNotFoundException | MaxBorrowLimitException | ItemNotAvailableForClientException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println();
            library.returnItem(1, 1); // return book 1
            library.displayClientBorrowedItems(1);

        } catch (ItemNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println();
            // Mazen borrows again
            library.borrowItem(1, 3);
            // Lobna with same book
            library.borrowItem(2, 3);

        } catch (ItemNotFoundException | MaxBorrowLimitException | ItemNotAvailableForClientException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println();
            // book doesn't exsit

            library.borrowItem(2, 10);

        } catch (ItemNotFoundException | MaxBorrowLimitException | ItemNotAvailableForClientException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // book doesn't exsit
            System.out.println();
            library.borrowItem(2, 1);
            library.borrowItem(2, 2);
            library.borrowItem(2, 5);
            library.borrowItem(2, 4);

        } catch (ItemNotFoundException | MaxBorrowLimitException | ItemNotAvailableForClientException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
        library.displayAllClients();

        try {
            // updating a book
            System.out.println();
            Book NewBook = new Book(1, "C++ NEW", 10, "New C++Publisher", "New Author", 1000999L);
            library.updateItem(NewBook);
            System.out.println("Updated book with ID 1:");
            System.out.println(library.findItemById(1).getItemDetails());
        } catch (ItemNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // updating a cleint
            System.out.println();
            Client updatedClient = new Client(2, "Lobna Updated", "lobna.new@email.com");
            library.updateClient(updatedClient);
            System.out.println("Updated client with ID 2:");
            System.out.println(library.findClientById(2).getClientDetails());
        } catch (ItemNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // deleting a book
            System.out.println();
            System.out.println("Before delete:");
            library.displayAllItems();

            library.removeItem(5);

            System.out.println("After deleting item ID 5:");
            library.displayAllItems();
        } catch (ItemNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // deleting a client
            System.out.println();
            System.out.println("Before delete:");
            library.displayAllClients();

            library.removeClient(2);

            System.out.println("After deleting client ID 2:");
            library.displayAllClients();
        } catch (ItemNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // adding a duplicate book
        System.out.println();
        Book duplicateBook = new Book(1, "a book with id 1", 1, "test", "test", 123L);
        library.addItem(duplicateBook);

        // adding a duplicate client
        System.out.println();
        Client duplicateClient = new Client(1, "Existing client", "exists@test.com");
        library.addClient(duplicateClient);

        try {
            System.out.println();
            System.out.println("item 1 available? " + library.isItemAvailable(1));
            System.out.println("item 3 available? " + library.isItemAvailable(3));
        } catch (ItemNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println();
            library.removeItem(999);
        } catch (ItemNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println();
            Client fakeClient = new Client(999, "Not Found client", "errorrr@test.com");
            library.updateClient(fakeClient);
        } catch (ItemNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}

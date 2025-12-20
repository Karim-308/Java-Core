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

    }
}

package lab9.model;

import java.util.ArrayList;
import java.util.List;

import lab9.exception.ItemNotAvailableForClientException;
import lab9.exception.ItemNotFoundException;
import lab9.exception.MaxBorrowLimitException;

public class Library {
    private List<LibraryItem> items;
    private List<Client> clients;

    public Library() {
        this.items = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        if (itemIdExists(item.getId())) {
            System.out.println("Can't add Item " + item.getTitle() + " , it already exists");
        } else {
            items.add(item);
        }
    }

    public LibraryItem findItemById(int id) throws ItemNotFoundException {
        return items.stream().filter(item -> item.getId() == id).findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Item with ID " + id + " not found!"));
    }


    public void displayAllItems() {
        if (items.isEmpty()) {
            System.out.println("No items in library.");
            return;
        }
        items.stream()
                .map(LibraryItem::getItemDetails).forEach(System.out::println);
    }

    public boolean itemIdExists(int id) {
        return items.stream().anyMatch(item -> item.getId() == id);
    }

    public void removeItem(int id)throws ItemNotFoundException  {
        items.remove(findItemById(id));
    }

    public void addClient(Client client) {
        if (clientIdExists(client.getId())) System.out.println("Can't add client:" + client + ", client already exists");
        else clients.add(client);
    }

    public Client findClientById(int id) throws ItemNotFoundException {
        return clients.stream().filter(client -> client.getId() == id).findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Client with ID " + id + " not found!"));
    }

    public void displayAllClients() {
        if (clients.isEmpty()) {
            System.out.println("No clients registered.");
            return;
        }
        clients.stream().map(Client::getClientDetails).forEach(System.out::println);
    }

    public boolean clientIdExists(int id) {
        return clients.stream().anyMatch(client -> client.getId() == id);
    }

    public void removeClient(int id) throws ItemNotFoundException {

        clients.remove(findClientById(id));
    }

    public List<LibraryItem> getItems() {
        return items;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void borrowItem(int clientId, int itemId) throws ItemNotFoundException, MaxBorrowLimitException, ItemNotAvailableForClientException {

        Client client = findClientById(clientId);
        LibraryItem item = findItemById(itemId);

        if (item.getStock() <= 0) {
            throw new ItemNotFoundException(
                    "Item '" + item.getTitle() + "' is out of stock!");
        }
        client.borrowItem(item);

        item.setStock(item.getStock() - 1);

        System.out.println("Success! " + client.getName() + " borrowed '" + item.getTitle() + "'");
    }

    public void displayClientBorrowedItems(int clientId) throws ItemNotFoundException {
        Client client = findClientById(clientId);
        client.displayBorrowedItems();
    }

    public boolean isItemAvailable(int itemId) throws ItemNotFoundException {
        LibraryItem item = findItemById(itemId);
        return item.getStock() > 0;
    }

    public void returnItem(int clientId, int itemId) throws ItemNotFoundException {
        Client client = findClientById(clientId);
        LibraryItem item = findItemById(itemId);

        if (!client.hasBorrowed(item)) {
            throw new ItemNotFoundException(
                    "Client " + client.getName() + " has not borrowed '" + item.getTitle() + "'!");
        }
        client.returnItem(item);
        item.setStock(item.getStock() + 1);
        System.out.println("Success! " + client.getName() + " returned '" + item.getTitle() + "'");
    }

}

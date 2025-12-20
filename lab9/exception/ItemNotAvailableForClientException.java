package lab9.exception;

public class ItemNotAvailableForClientException extends Exception {

    public ItemNotAvailableForClientException(String message) {
        super(message);
    }
}

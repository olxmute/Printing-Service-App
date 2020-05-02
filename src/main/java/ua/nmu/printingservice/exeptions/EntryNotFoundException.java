package ua.nmu.printingservice.exeptions;

public class EntryNotFoundException extends RuntimeException {
    protected EntryNotFoundException(String message) {
        super(message);
    }
}

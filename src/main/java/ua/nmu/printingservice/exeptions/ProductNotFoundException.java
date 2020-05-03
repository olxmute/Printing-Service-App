package ua.nmu.printingservice.exeptions;

public class ProductNotFoundException extends EntryNotFoundException {
    public ProductNotFoundException() {
        super("Product not found!");
    }
}

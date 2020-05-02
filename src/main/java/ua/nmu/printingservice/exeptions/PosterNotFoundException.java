package ua.nmu.printingservice.exeptions;

public class PosterNotFoundException extends EntryNotFoundException {
    public PosterNotFoundException() {
        super("Poster not found!");
    }
}

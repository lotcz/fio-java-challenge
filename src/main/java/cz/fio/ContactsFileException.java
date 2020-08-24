package cz.fio;

/**
 * Represents exception related to contacts file reading and writing.
 */
public class ContactsFileException extends Exception {

    public ContactsFileException() {
        super("Unknown contacts file error.");
    }

    public ContactsFileException(String message) {
        super(message);
    }

    public ContactsFileException(String message, Exception parent) {
        super(message, parent);
    }

}

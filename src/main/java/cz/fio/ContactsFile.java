package cz.fio;

import java.io.FileNotFoundException;

/**
 * Represents a general file with contacts.
 */
public interface ContactsFile {

    /**
     * Check if contact already exists in the file.
     * @param contact
     * @return True if same contact already exist.
     */
    boolean exists(Contact contact) throws ContactsFileException;

    /**
     * Add contact to the file if same contact doesn't already exist in the file.
     * @param contact
     */
    void add(Contact contact) throws ContactsFileException;

}

package cz.fio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Used for creating contacts file objects.
 * In this example, we only have a single implementation CsvContactsFile that is always used.
 */
public class ContactsFileFactory {

    public ContactsFileFactory() {

    }

    public ContactsFile getInstance() {
        // here we could select different implementation or configuration

        // use system temp dir
        Path path = Paths.get(System.getProperty("java.io.tmpdir"), "contacts.csv");

        return new CsvContactsFile(path);
    }
}

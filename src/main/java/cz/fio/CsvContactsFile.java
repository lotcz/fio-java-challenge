package cz.fio;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;

/**
 * Represents contacts file stored as CSV.
 */
public class CsvContactsFile implements ContactsFile {

    private Path path;

    public CsvContactsFile(Path path) {
        this.path = path;
    }

    private static CSVFormat csvFormat;

    private static CSVFormat getCsvFormat() {
        if (CsvContactsFile.csvFormat == null) {
            CsvContactsFile.csvFormat = CSVFormat.DEFAULT
                    .withAllowMissingColumnNames()
                    .withTrim()
                    .withIgnoreEmptyLines();
        }
        return CsvContactsFile.csvFormat;
    }

    private static Charset charset;

    private static Charset getCharset() {
        if (CsvContactsFile.charset == null) {
            CsvContactsFile.charset = Charset.forName("WINDOWS-1250");
        }
        return CsvContactsFile.charset;
    }

    @Override
    public boolean exists(Contact contact) throws ContactsFileException {
        File file = new File(this.path.toString());
        if (file.exists()) {
            try {
                Reader in = new InputStreamReader(new FileInputStream(file), CsvContactsFile.getCharset());
                try {
                    Iterable<CSVRecord> records = CsvContactsFile.getCsvFormat().parse(in);
                    for (CSVRecord record : records) {
                        Contact existingContact = new Contact();
                        existingContact.setFirstName(record.get(0));
                        existingContact.setLastName(record.get(1));
                        existingContact.setEmail(record.get(2));
                        if (existingContact.equals(contact)) {
                            return true;
                        }
                    }
                    return false;
                } finally {
                    in.close();
                }
            } catch (Exception ex) {
                throw new ContactsFileException("File reading failed!", ex);
            }
        } else {
            return false;
        }
    }

    @Override
    public void add(Contact contact) throws ContactsFileException {
        try {
            Writer out = new OutputStreamWriter(new FileOutputStream(this.path.toString(), true), CsvContactsFile.getCharset());
            try {
                CSVPrinter printer = CsvContactsFile.getCsvFormat().print(out);
                printer.printRecord(contact.getFirstName(), contact.getLastName(), contact.getEmail());
                printer.flush();
            } finally {
                out.close();
            }
        } catch (Exception ex) {
            throw new ContactsFileException("File write failed!");
        }
    }
}

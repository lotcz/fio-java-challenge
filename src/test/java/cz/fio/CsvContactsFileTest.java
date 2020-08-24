package cz.fio;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CsvContactsFileTest {

    private CsvContactsFile resetFile() throws Exception {
        // use system temp dir
        Path path = Paths.get(System.getProperty("java.io.tmpdir"), "contacts_test.csv");

        File file = new File(path.toString());
        if (file.exists()) {
            if (!file.delete()) {
                throw new Exception("Cannot delete test file!");
            }
        }

        return new CsvContactsFile(path);
    }

    @Test
    public void testAddAndExists() throws Exception {
        Contact johny = new Contact();
        johny.setFirstName("Johny");
        johny.setLastName("Mnemonic");
        johny.setEmail("johny@mnemonic.com");

        Contact blade = new Contact();
        blade.setFirstName("Blade");
        blade.setLastName("Runner");
        blade.setEmail("blade@runner.com");

        CsvContactsFile file = this.resetFile();

        Assert.assertFalse(file.exists(johny));
        Assert.assertFalse(file.exists(blade));

        file.add(johny);
        Assert.assertTrue(file.exists(johny));
        Assert.assertFalse(file.exists(blade));

        file.add(blade);
        Assert.assertTrue(file.exists(johny));
        Assert.assertTrue(file.exists(blade));
    }

}

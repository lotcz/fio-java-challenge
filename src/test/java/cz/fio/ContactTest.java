package cz.fio;

import org.junit.Assert;
import org.junit.Test;

public class ContactTest {

    @Test
    public void testGettersSetters() {
        Contact contact = new Contact();
        contact.setFirstName("First Name");
        contact.setLastName("Last Name");
        contact.setEmail("test@test.com");

        Assert.assertEquals("First Name", contact.getFirstName());
        Assert.assertEquals("Last Name", contact.getLastName());
        Assert.assertEquals("test@test.com", contact.getEmail());
    }

    @Test
    public void testEquals() {
        Contact johny = new Contact();
        johny.setFirstName("Johny");
        johny.setLastName("Mnemonic");
        johny.setEmail("johny@mnemonic.com");

        Contact blade = new Contact();
        blade.setFirstName("Blade");
        blade.setLastName("Runner");
        blade.setEmail("blade@runner.com");

        Assert.assertTrue(johny.equals(johny));
        Assert.assertTrue(blade.equals(blade));

        Assert.assertFalse(johny.equals(blade));
        Assert.assertFalse(blade.equals(johny));

        johny.setFirstName("Blade");
        Assert.assertFalse(johny.equals(blade));
        Assert.assertFalse(blade.equals(johny));

        johny.setLastName("Runner");
        Assert.assertFalse(johny.equals(blade));
        Assert.assertFalse(blade.equals(johny));

        johny.setEmail("blade@runner.com");
        Assert.assertTrue(johny.equals(blade));
        Assert.assertTrue(blade.equals(johny));
    }
    
}

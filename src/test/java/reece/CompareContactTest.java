package reece;
import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class CompareContactTest{

    private Contact contact1;
    private Contact contact2;
    private Contact contact3;
    private Contact contact4;
    private Contact contact5;

    /**
     * Initializing few contacts
     */
    @Before 
    public void initialize() {
        contact1 = new Contact("John", "0422435655");
        contact2 = new Contact("JOHN", "0422435655");
        contact3 = new Contact("John", "9999999999");
        contact4 = new Contact("Alex", "0433889977");
        contact5 = new Contact("Simon", "0443889977");
    }

    /**
     * Test for equals method of Contact class. Two Contacts are equal only if the contact names and phone numbers are equal.
     */
    @Test
    public void testEqualContacts() {
        assertTrue(contact1.equals(contact2));
        assertTrue(contact2.equals(contact1));
        assertFalse(contact1.equals(contact3));
        assertFalse(contact3.equals(contact1));
        assertFalse(contact4.equals(contact5));
    }
    /**
     * Test for compareTo method of Contact class. 
     * compareTo returns 0 if contacts are equal, greater than 0 if this Contact is greater than specified Contact, and less.
     */
    @Test
    public void testCompareContacts() {
        assertTrue(contact1.compareTo(contact2) == 0);
        assertTrue(contact2.compareTo(contact1) == 0);
        assertTrue(contact1.compareTo(contact3) < 0);
        assertTrue(contact3.compareTo(contact1) > 0);
        assertTrue(contact4.compareTo(contact5) < 0);
    }

}
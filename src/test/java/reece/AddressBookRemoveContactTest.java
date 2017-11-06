package reece;
import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class AddressBookRemoveContactTest{

    private Contact contact1;
    private Contact contact2;
    private Contact contact3;
    /**
     * Address book
     */
    private AddressBook addressBook;

    /**
     * Initializing few contacts and a simple address book
     */
    @Before 
    public void initialize() {
        contact1 = new Contact("John", "0422435655");
        contact2 = new Contact("John", "9999999999");
        contact3 = new Contact("Nic", "049982845");
        addressBook = new SimpleAddressBook("addrBook1");
    }

    /**
     * Test for removing none-existent contact from address book
     */
    @Test
    public void testRemoveNonExistentContactFromAddressBook() {
        assertFalse(addressBook.getContacts().contains(contact3));
        assertFalse(addressBook.removeContact(contact3));
        assertFalse(addressBook.getContacts().contains(contact3));  
    }

    /**
     * Test for removing a contact from address book
     */
    @Test
    public void testRemoveContactFromAddressBook() {
        addressBook.addContact(contact1);
        addressBook.addContact(contact2);
        addressBook.removeContact(contact1);
        assertFalse(addressBook.getContacts().contains(contact1));
    }
}
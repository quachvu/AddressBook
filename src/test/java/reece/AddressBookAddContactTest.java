package reece;
import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.BeforeClass;
import org.junit.Test;

public class AddressBookAddContactTest{

    private static Contact contact1;
    private static Contact contact2;
    private static Contact contact3;
    /**
     * Address book
     */
    private static AddressBook addressBook;
    /**
     * Contact list size before calling a specific method.
     */
    private int contactSizeBefore;
    /**
     * Contact list size after calling a specific method.
     */
    private int contactSizeAfter;

    /**
     * Initializing new contacts and an address book
     */
    @BeforeClass
    public static void initialize() {
        contact1 = new Contact("John", "0422435655");
        contact2 = new Contact("John", "9999999999");
        contact3 = new Contact("Alex", "0433889977");
//        List<Contact> contacts = new ArrayList<Contact>();
//        contacts.add(contact1);
//        contacts.add(contact2);
//        contacts.add(contact3);
        
//        addressBook = new SimpleAddressBook("addrBook1");
        addressBook = new AddressBook("AddressBookA");
//        addressBook.setContacts(contacts);
    }

    /**
     * Test add zero contact to address book
     */
    @Test
    public void testAddZeroContactToAddressBook() {
        assertEquals(addressBook.getContacts().size(), 0);  
    }

    /**
     * Test add one contact to address book
     */
    @Test
    public void testAddOneContactToAddressBook() {
        contactSizeBefore = addressBook.getContacts().size();
        addressBook.addContact(contact1);
        contactSizeAfter = addressBook.getContacts().size();
        assertEquals(contactSizeAfter - contactSizeBefore, 1);

        Iterator<Contact> contactIt = addressBook.getContacts().iterator();
        while (contactIt.hasNext()) {
            assertEquals(contactIt.next(), contact1);
        }   
    }

    /**
     * Test add multiple contacts to address book
     */
    @Test
    public void testAddMultipleContactsToAddressBook() {
        contactSizeBefore = addressBook.getContacts().size();
        addressBook.addContact(contact1);
        addressBook.addContact(contact2);
        addressBook.addContact(contact3);
        contactSizeAfter = addressBook.getContacts().size();
        assertEquals(contactSizeAfter - contactSizeBefore, 3);  
    }

    /**
     * Test add multiple contacts with duplicates to address book
     */
    @Test
    public void testAddMultipleContactsWithDuplicateToAddressBook() {
        // contact list accepts duplicate contact
        contactSizeBefore = addressBook.getContacts().size();
        addressBook.addContact(contact1);
        addressBook.addContact(contact1);
        contactSizeAfter = addressBook.getContacts().size();
        assertEquals(contactSizeAfter - contactSizeBefore, 2);  
    }

    /**
     * Test add multiple contacts without duplicates to address book
     */
    @Test
    public void testAddContactsWithoutDuplicateToAddressBook() {    
        // contact list accepts duplicate contact
        contactSizeBefore = addressBook.getContacts().size();
        addressBook.addContact(contact1);
        addressBook.addContact(contact2);
        contactSizeAfter = addressBook.getContacts().size();
        assertEquals(contactSizeAfter - contactSizeBefore, 2);
    }
}
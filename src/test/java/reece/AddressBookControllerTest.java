package reece;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class AddressBookControllerTest{

    private AddressBookController adController;
    private AddressBook addressBook1;
    private AddressBook addressBook2;
    private Contact contact1;
    private Contact contact2;
    private Contact contact3;
    private Contact contact4;
    private Contact contact5;
    private Contact contact6;


    @Before 
    public void initialize() {
        adController = new AddressBookController();
        addressBook1 = new AddressBook("addrBook1");
        addressBook2 = new AddressBook("addrBook2");
        contact1 = new Contact("John", "0422435655");
        contact2 = new Contact("John", "9999999999");
        contact3 = new Contact("Alex", "0433889977");
        contact4 = new Contact("Simon", "0423888511");
        contact5 = new Contact("Asghar", "0499888");
        contact6 = new Contact("George", "0499888");
    }

    /**
     * Test for adding one address book with multiple contacts to an address book controller.
     */
    @Test
    public void addOneAddressBookTest() {
        final int addrBookSizeBefore = adController.getAddressBooks().size();
        final int contactSizeBefore = addressBook1.getContacts().size();
        addressBook1.addContact(contact1);
        addressBook1.addContact(contact2);
        addressBook1.addContact(contact3);
        addressBook1.addContact(contact4);
        adController.addAddressBook(addressBook1);
        final int addrBookSizeAfter = adController.getAddressBooks().size();
        final int contactSizeAfter = addressBook1.getContacts().size();
        assertEquals(addrBookSizeAfter - addrBookSizeBefore, 1);
        assertEquals(contactSizeAfter - contactSizeBefore, 4);
    }

    /**
     * Test for adding multiple address books with multiple contacts to an address book controller.
     */
    @Test
    public void addMultipleAddressBookTest() {
        final int noAddrBooksBefore = adController.getAddressBooks().size();
        final int noContactsAddr1Before = addressBook1.getContacts().size();
        addressBook1.addContact(contact1);
        addressBook1.addContact(contact2);
        adController.addAddressBook(addressBook1);

        final int noContactsAddr2Before = addressBook2.getContacts().size();
        addressBook2.addContact(contact3);
        addressBook2.addContact(contact4);
        adController.addAddressBook(addressBook2);

        final int noAddrBooksAfter = adController.getAddressBooks().size();
        final int noContactsAddr1After = addressBook1.getContacts().size();
        final int noContactsAddr2After = addressBook2.getContacts().size();

        assertEquals(noAddrBooksAfter - noAddrBooksBefore, 2);
        assertEquals(noContactsAddr1After - noContactsAddr1Before, 2);
        assertEquals(noContactsAddr2After - noContactsAddr2Before, 2);
    }

    /**
     * Test for retrieving all the contacts of all address book from address book controller.
     * Duplicate contact is allowed in this list.
     */
    @Test
    public void getAllContactsTest() {
        final int noContactsBefore = adController.getAllContacts().size();
        addressBook1.addContact(contact1);
        addressBook1.addContact(contact3);
        addressBook1.addContact(contact1);

        addressBook2.addContact(contact1);
        addressBook2.addContact(contact2);
        addressBook2.addContact(contact4);

        adController.addAddressBook(addressBook1);
        adController.addAddressBook(addressBook2);

        final int noContactsAfter = adController.getAllContacts().size();
        assertEquals(noContactsAfter - noContactsBefore, 6);
    }

    /**
     * Test for removing an address books with multiple contacts from address book controller.
     */
    @Test
    public void removeAddressBookTest() {
        addressBook1.addContact(contact1);
        addressBook1.addContact(contact3);

        addressBook2.addContact(contact2);
        addressBook2.addContact(contact4);

        adController.addAddressBook(addressBook1);
        adController.addAddressBook(addressBook2);

        final int addrBookSizeBefore = adController.getAddressBooks().size();
        final int contactSizeBefore = adController.getAllContacts().size();
        adController.removeAddressBook(addressBook1);
        final int addrBookSizeAfter = adController.getAddressBooks().size();
        final int contactSizeAfter = adController.getAllContacts().size();

        assertEquals(addrBookSizeAfter - addrBookSizeBefore, -1);
        assertEquals(contactSizeAfter - contactSizeBefore, -2);
    }

    /**
     * Test for retrieving unique contacts of all address books from address book controller.
     */
    @Test
    public void getUniqueContactsAcrossAddrBooksTest() {

        addressBook1.addContact(contact1);
        addressBook1.addContact(contact3);
        addressBook1.addContact(contact1);
        addressBook1.addContact(contact5);
        addressBook1.addContact(contact6);

        addressBook2.addContact(contact1);
        addressBook2.addContact(contact2);
        addressBook2.addContact(contact4);
        addressBook2.addContact(contact6);

        adController.addAddressBook(addressBook1);
        adController.addAddressBook(addressBook2);

        // expected unique contacts
        List<Contact> expectedUniqueContacts = new ArrayList<Contact>();
        expectedUniqueContacts.add(contact3);
        expectedUniqueContacts.add(contact2);
        expectedUniqueContacts.add(contact4);
        expectedUniqueContacts.add(contact5);

        // expected common contacts
        List<Contact> expectedCommonContacts = new ArrayList<Contact>();
        expectedCommonContacts.add(contact1);
        expectedCommonContacts.add(contact6);

        // getting all unique contacts
        Set<Contact> uniqueContacts = adController.getUniqueContacts();

        // all the expected unique contacts should be included in the output unique contact list.
        for (Contact contact : expectedUniqueContacts) {
            assertTrue(uniqueContacts.contains(contact));
        }
        // none of the excepted common contacts should be in the output unique contact list.
        for (Contact contact : expectedCommonContacts) {
            assertFalse(uniqueContacts.contains(contact));
        }
    }

    /**
     * Test for printing unique contacts of all address books in address book controller.
     */
    @Test
    public void printUniqueContactsAcrossAddrBooksTest() {
        addressBook1.addContact(contact1);
        addressBook1.addContact(contact3);
        addressBook1.addContact(contact1);
        addressBook1.addContact(contact5);
        addressBook1.addContact(contact6);

        addressBook2.addContact(contact1);
        addressBook2.addContact(contact2);
        addressBook2.addContact(contact4);
        addressBook2.addContact(contact6);

        adController.addAddressBook(addressBook1);
        adController.addAddressBook(addressBook2);
        adController.printUniqueContacts();
    }

}
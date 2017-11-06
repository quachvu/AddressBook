package reece;
import org.junit.Before;
import org.junit.Test;

public class AddressBookPrintContactTest {

    /**
     * Address book
     */
    private AddressBook addressBook;

    /**
     * Initializing an empty address book
     */
    @Before 
    public void initialize() {
        addressBook = new SimpleAddressBook("addrBook1");
    }

    /**
     * Test expects EmptyAddressBookException when printing an empty address book.
     * @throws EmptyAddressBookException 
     */
    @Test(expected=EmptyAddressBookException.class)
    public void testPrintContacts() throws EmptyAddressBookException {
        addressBook.printContacts();
    }

}
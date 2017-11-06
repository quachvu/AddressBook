package reece;

import junit.framework.TestCase;

import org.junit.Test;


public class AddContactTest extends TestCase{

    /**
     * Test 1 for invalid contact with empty contact name
     */
    @Test(expected=IllegalArgumentException.class)
    public void testInvalidContactName1() {
        new Contact("", "0422435655");
    }

    /**
     * Test 2 for invalid contact with null contact name
     */
    @Test(expected=IllegalArgumentException.class)
    public void testInvalidContactName2() {
        new Contact(null, "9999999999");
    }

    /**
     * Test 3 for invalid contact with null contact phone number
     */
    @Test(expected=IllegalArgumentException.class)
    public void testInvalidContactPhoneNo1() {
        new Contact("Simon", null);
    }

    /**
     * Test 4 for invalid contact with empty contact phone number
     */
    @Test(expected=IllegalArgumentException.class)
    public void testInvalidContactPhoneNo2() {
        new Contact("Simon", "");
    }

    /**
     * Test 5 for invalid contact with a contact phone number having non-digit characters
     */
    @Test(expected=IllegalArgumentException.class)
    public void testInvalidContactPhoneNo3() {
        new Contact("Alex", "043C8+9977");
    }

    /**
     * Test 6 for invalid contact with a contact phone number having non-digit characters
     */
    @Test(expected=IllegalArgumentException.class)
    public void testInvalidContactPhoneNo4() {
        new Contact("Simon", "9877c9876");
    }

    /**
     * Test 7 for valid contact with valid contact names and phone numbers
     */
    @Test
    public void testValidContacts() {
        Contact contact = new Contact("Simon", "9");
        assertEquals(contact.getName(), "Simon");
        assertEquals(contact.getPhoneNumber(), "9");

        contact = new Contact("Sn", "9980980");
        assertEquals(contact.getName(), "Sn");
        assertEquals(contact.getPhoneNumber(), "9980980");
    }
}
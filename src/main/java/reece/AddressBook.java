package reece;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

        List<Contact> contacts;
        private String name;

        public AddressBook(final String name) {
            this.name = name;
            contacts = new ArrayList<Contact>();
        }

        public void addContact(final Contact contact) {
            contacts.add(contact);
        }

        public boolean removeContact(Contact contact) {
            return contacts.remove(contact);    
        }

        public void printContacts() throws EmptyAddressBookException {
            if (getContacts() != null && !getContacts().isEmpty()) {
                System.out.println(this);
            } else {
                throw new EmptyAddressBookException(Constants.Exceptions.EMPTY_ADDRESS_BOOK_ERROR_MSG);
            }
        }

		public List<Contact> getContacts() {
			return contacts;
		}

		public void setContacts(List<Contact> contacts) {
			this.contacts = contacts;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

        /** setters, getters, toString **/
        
    }
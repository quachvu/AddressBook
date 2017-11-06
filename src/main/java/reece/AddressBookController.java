package reece;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AddressBookController {

    final List<AddressBook> addressBooks;

    public AddressBookController() {
        addressBooks = new ArrayList<AddressBook>();
    }

    public List<AddressBook> getAddressBooks() {
        return addressBooks;
    }

    public void addAddressBook(AddressBook addressBook) {
        addressBooks.add(addressBook);
    }

    public boolean removeAddressBook(AddressBook addressBook) {
        return addressBooks.remove(addressBook);    
    }

    public List<Contact> getAllContacts() {
        final List<Contact> allContacts = new ArrayList<Contact>();
        for (AddressBook addrBook : getAddressBooks()) {
            allContacts.addAll(addrBook.getContacts());
        }
        return allContacts;
    }


    public Set<Contact> getUniqueContacts() {

        Set<Contact> uniqueContacts = new TreeSet<Contact>();
        Set<Contact> commonContacts = new HashSet<Contact>();
        Set<Contact> allContacts = new HashSet<Contact>();
        List<Contact> contacts = null;

        for (AddressBook addrBook : addressBooks) {
            contacts = addrBook.getContacts();

            allContacts.addAll(uniqueContacts);
            allContacts.addAll(contacts);

            contacts.retainAll(uniqueContacts); 
            commonContacts.addAll(contacts);
            allContacts.removeAll(commonContacts); 

            uniqueContacts.clear();
            uniqueContacts.addAll(allContacts);
        }

        return uniqueContacts;
    }

    public void printUniqueContacts() {
        Set<Contact> uniqueContacts = getUniqueContacts();
        Iterator<Contact> itr = uniqueContacts.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

}
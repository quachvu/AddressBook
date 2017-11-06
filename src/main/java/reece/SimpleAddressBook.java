package reece;

import java.io.Serializable;

public class SimpleAddressBook extends AddressBook implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor calls the parent class constructor.
     * @param name -- simple address book name
     */
    public SimpleAddressBook(final String name) {
        super(name);
    }

}
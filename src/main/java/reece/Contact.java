package reece;

public class Contact implements Comparable<Contact>{

        private String name;
        private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        setName(name);
        setPhoneNumber(phoneNumber);
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
        return result;
    }

    /**
     * Compares this Contact to the specified object.
     * Two Contacts are equal only if the contact names and phone numbers are equal.
     * Comparison ignores case considerations.
     */
    @Override
    public boolean equals(Object contact) {
        boolean areEquals = false;
        if (contact instanceof Contact) {
            Contact other = (Contact) contact;
            if (other.name.equalsIgnoreCase(name) 
                && other.phoneNumber.equalsIgnoreCase(phoneNumber) ) {
                areEquals = true;
            }
        }
        return areEquals;
    }

    /**
     * Returns a string representation of the Contact. 
     */
    @Override
    public String toString() {
        return "Contact [name=" + name + ", phoneNumber=" + phoneNumber + "]";
    }

    /**
     * Compares two Contacts lexicographically based on the contact name and if the names are equal compares the contact phone numbers.
     * The comparison is based on the Unicode value of each character in the contact name String and contact phone number String.
     * Comparison ignores case considerations.
     * 
     * @return 0 if contacts are equal, greater than 0 if this Contact is greater than specified Contact, and less
     * than 0, otherwise.
     * For Example:
     * returns 0 this Contact("joHN", "04334433") and specified Contact("JOHN", "04334433")
     * returns greater than 0 this Contact("John", "0422435655") and specified Contact("John", "9999999999")
     * returns less than 0 this Contact("John", "9999999999") and specified Contact("John", "0422435655")
     */
    public int compareTo(Contact otherContact) {
        final int compareName = name.compareToIgnoreCase(otherContact.getName());
        final int comparePhoneNo = phoneNumber.compareToIgnoreCase(otherContact.getPhoneNumber());
        if (compareName == 0) {
            return comparePhoneNo;
        } else {
            return compareName;
        }
    }
    /** setters and getters **/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

    
    
}
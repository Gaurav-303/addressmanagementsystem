package book;



public class AddressBook {
    private final String name;
    private final List<Contact> contacts = new ArrayList<>();

    public AddressBook(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    // UC1: Add Contact
    public void addContact(Contact c) {
        contacts.add(c);
    }
}

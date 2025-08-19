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
    // UC2: Edit Contact
    public boolean editContact(String firstName, String lastName, Contact updated) {
        Contact existing = findContact(firstName, lastName);
        if (existing != null) {
            existing.setAddress(updated.toString());
            return true;
        }
        return false;
    }
    // UC3: Delete Contact
    public boolean deleteContact(String firstName, String lastName) {
        Contact c = findContact(firstName, lastName);
        return (c != null) && contacts.remove(c);
    }

    private Contact findContact(String fn, String ln) {
        return contacts.stream()
                .filter(c -> c.getFirstName().equalsIgnoreCase(fn)
                        && c.getLastName().equalsIgnoreCase(ln))
                .findFirst().orElse(null);
    }
}

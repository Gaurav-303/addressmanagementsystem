package book;

import java.util.*;

public class AddressBookMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, AddressBook> system = new HashMap<>();
        system.put("Default", new AddressBook("Default"));
        AddressBook current = system.get("Default");

        System.out.println("Welcome to Address Book Program");

        while (true) {
            System.out.println("\n1) Add  2) Edit  3) Delete  4) Add Multiple  5) New Book  6) Switch Book  0) Exit");
            String choice = in.nextLine().trim();

            switch (choice) {
                case "1" -> current.addContact(promptContact(in));
                case "2" -> {
                    System.out.print("First name to edit: "); String fn = in.nextLine();
                    System.out.print("Last name to edit: "); String ln = in.nextLine();
                    boolean ok = current.editContact(fn, ln, promptContact(in));
                    System.out.println(ok ? "Edited" : "Not found");
                }
                case "3" -> {
                    System.out.print("First name to delete: "); String fn = in.nextLine();
                    System.out.print("Last name to delete: "); String ln = in.nextLine();
                    System.out.println(current.deleteContact(fn, ln) ? "Deleted" : "Not found");
                }
                case "4" -> {
                    System.out.print("How many contacts? "); int n = Integer.parseInt(in.nextLine());
                    for (int i=0;i<n;i++) current.addContact(promptContact(in));
                }
                case "5" -> {
                    System.out.print("New book name: "); String name = in.nextLine();
                    if (system.containsKey(name)) System.out.println("Book already exists");
                    else { system.put(name, new AddressBook(name)); System.out.println("Created "+name); }
                }
                case "6" -> {
                    System.out.print("Switch to book name: "); String name = in.nextLine();
                    if (system.containsKey(name)) { current = system.get(name); System.out.println("Switched to "+name); }
                    else System.out.println("Not found");
                }
                case "0" -> { System.out.println("Thank You!"); return; }
                default -> System.out.println("Invalid choice");
            }
            System.out.println("\nContacts in "+current.getName()+":");
            current.getContacts().forEach(System.out::println);
        }
    }

    private static Contact promptContact(Scanner in) {
        System.out.print("First Name: "); String fn = in.nextLine();
        System.out.print("Last Name: "); String ln = in.nextLine();
        System.out.print("Address: "); String addr = in.nextLine();
        System.out.print("City: "); String city = in.nextLine();
        System.out.print("State: "); String state = in.nextLine();
        System.out.print("Zip: "); String zip = in.nextLine();
        System.out.print("Phone: "); String phone = in.nextLine();
        System.out.print("Email: "); String email = in.nextLine();
        return new Contact(fn, ln, addr, city, state, zip, phone, email);
    }
}


package addressBook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Address Book Menu:");
            System.out.println("1. Add new contact");
            System.out.println("2. Find a contact by name");
            System.out.println("3. Display contacts");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    findContactByName();
                    break;
                case 3:
                    displayContacts();
                    break;
                case 4:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter company: ");
        String company = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        Contact contact = new Contact(name, company, email, phone);
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }

    private static void findContactByName() {
        System.out.print("Enter name to search: ");
        String searchName = scanner.nextLine();
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Phone number: " + contact.getPhone());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    private static void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts to display.");
        } else {
            System.out.println("Contacts:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }
}

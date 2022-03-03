import java.util.List;
import java.util.Scanner;

public class PhoneContactsMain {
    private static PhoneBook phoneBook;

    public static void main(String[] args) {
        phoneBook = new PhoneBook();

        phoneBook.addGroupContact("Home");
        phoneBook.addGroupContact("Work");

        Contact contact1 = new Contact("Petya","+7(961)-777-77-77");
        Contact contact2 = new Contact("Vasya","+7(904)-777-77-77");

        phoneBook.addContactToGroup(contact1, "Home");
        phoneBook.addContactToGroup(contact1, "Work");

        phoneBook.addContactToGroup(contact2, "Home");

        phoneBook.printGroupContacts();

        List<Contact> contacts = phoneBook.findContactsByGroup("Home");
        System.out.println();
        System.out.println(contacts);

        System.out.println(phoneBook.findContactByPhoneNumber("+7(961)-777-77-77"));
    }
}

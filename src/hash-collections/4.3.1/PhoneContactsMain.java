import java.util.Scanner;

public class PhoneContactsMain {
    private static Scanner scanner = new Scanner(System.in);
    private static PhoneContacts phoneContacts;

    public static void main(String[] args) {
        phoneContacts = new PhoneContacts();
        requestGroups();
        requestContacts();
        phoneContacts.printGroupContacts();
    }

    private static void requestGroups() {
        System.out.println("Программа справочник");
        System.out.println("Введите название группы контактов:");
        String newGroupContact = scanner.nextLine();
        while (!"нет".equals(newGroupContact.toLowerCase())) {
            phoneContacts.addGroupContact(newGroupContact);
            System.out.println("Создать еще одну группу (введите название или введите нет)?");
            newGroupContact = scanner.nextLine();
        }
    }

    private static void requestContacts() {
        System.out.println("Создать контакт (введите наименование и его номер или введите нет)?");
        String contactString = scanner.nextLine();
        Contact contact = null;
        while (!"нет".equals(contactString.toLowerCase())){

            contact = phoneContacts.createContactFromString(contactString);
            System.out.println("Укажите группы контакта через пробел");
            String groupsString = scanner.nextLine();
            if (contact != null) phoneContacts.addContactToGroup(contact, groupsString);

            System.out.println("Создать контакт (введите наименование и его номер или введите нет)?");
            contactString = scanner.nextLine();
        }
    }
}

public class PhoneContactsMain2 {
    private static PhoneBook2 phoneBook;

    public static void main(String[] args) throws InterruptedException {
        phoneBook = new PhoneBook2();

        phoneBook.addGroupContact("Home");
        phoneBook.addGroupContact("Work");

        Contact2 contact1 = new Contact2("Petya", "+7(961)-777-77-77");
        Contact2 contact2 = new Contact2("Vasya", "+7(904)-777-77-77");

        phoneBook.addContactToGroup(contact1, "Home");
        phoneBook.addContactToGroup(contact1, "Work");

        phoneBook.addContactToGroup(contact2, "Home");

        MissedCalls missedCalls = new MissedCalls();
        missedCalls.addMissedCalls("+7(904)-777-77-77");
        Thread.sleep(100);
        missedCalls.addMissedCalls("+7(905)-777-77-77");
        Thread.sleep(100);
        missedCalls.addMissedCalls("+7(906)-777-77-77");
        Thread.sleep(100);
        missedCalls.addMissedCalls("+7(907)-777-77-77");
        Thread.sleep(100);
        missedCalls.addMissedCalls("+7(904)-777-77-77");
        Thread.sleep(100);
        missedCalls.addMissedCalls("+7(961)-777-77-77");

        missedCalls.printMissedCalls(phoneBook);
    }
}

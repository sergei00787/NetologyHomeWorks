public class LibraryOffice {
    public static void main(String[] args) {
        Librarian librarian = new AdminLibrarian("Василиса Федоровна");
        Administrator admin = (Administrator) librarian;
        Supplier supplier = new SuppierReader("Петр Афанасьевич");
        Reader reader = (Reader) supplier;

        reader.takeBook("Война и мир", admin);
        reader.returnBook(55, admin);

        admin.overdueNotification(reader);
        librarian.orderBook(supplier, 55);
    }


}

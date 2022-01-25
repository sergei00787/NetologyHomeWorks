public class MainBookMover {
    public static void main(String[] args) {
        Book2 book1 = new Book2("Война и мир");

        System.out.println(book1.getStatus());
        BookMover bookMover = new FromAvailableStatusMover();
        bookMover.moveToStatus(book1, Status.OVERDUED);
        bookMover.moveToStatus(book1, Status.ARCHIVED);
        System.out.println(book1.getStatus());

        bookMover = new FromArchivedStatusMover();
        bookMover.moveToStatus(book1, Status.BORROWED);
        bookMover.moveToStatus(book1, Status.OVERDUED);
        bookMover.moveToStatus(book1, Status.AVAILABLE);
        System.out.println(book1.getStatus());

        bookMover = new FromAvailableStatusMover();
        bookMover.moveToStatus(book1, Status.BORROWED);
        System.out.println(book1.getStatus());

        bookMover = new FromBorrowedStatusMover();
        bookMover.moveToStatus(book1, Status.AVAILABLE);
        bookMover.moveToStatus(book1, Status.OVERDUED);
        System.out.println(book1.getStatus());

        bookMover = new FromOverduedStatusMover();
        bookMover.moveToStatus(book1, Status.BORROWED);
        bookMover.moveToStatus(book1, Status.OVERDUED);
        System.out.println(book1.getStatus());
        bookMover.moveToStatus(book1, Status.AVAILABLE);
        System.out.println(book1.getStatus());

    }
}

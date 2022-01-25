public class FromBorrowedStatusMover extends BookMover{
    @Override
    protected void moveToStatus(Book2 book, Status requestedStatus) {
        if (book.getStatus() == Status.BORROWED && (
                requestedStatus == Status.ARCHIVED || requestedStatus == Status.OVERDUED || requestedStatus == Status.BORROWED)) {
            book.setStatus(requestedStatus);
        } else {
            System.out.printf("Перевод книги из статуса %s в статус %s невозможен",
                    Status.BORROWED, requestedStatus);
            System.out.println();
        }
    }
}

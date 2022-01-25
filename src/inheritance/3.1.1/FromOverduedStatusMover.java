public class FromOverduedStatusMover extends BookMover{
    @Override
    protected void moveToStatus(Book2 book, Status requestedStatus) {
        if (book.getStatus() == Status.OVERDUED && (
                requestedStatus == Status.ARCHIVED || requestedStatus == Status.AVAILABLE || requestedStatus == Status.OVERDUED)) {
            book.setStatus(requestedStatus);
        } else {
            System.out.printf("Перевод книги из статуса %s в статус %s невозможен",
                    Status.OVERDUED, requestedStatus);
            System.out.println();
        }
    }
}

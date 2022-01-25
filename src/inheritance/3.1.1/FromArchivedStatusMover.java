public class FromArchivedStatusMover extends BookMover{
    @Override
    protected void moveToStatus(Book2 book, Status requestedStatus) {
        if (book.getStatus() == Status.ARCHIVED && requestedStatus == Status.AVAILABLE) {
            book.setStatus(requestedStatus);
        } else {
            System.out.printf("Перевод книги из статуса %s в статус %s невозможен",
                    Status.ARCHIVED, requestedStatus);
            System.out.println();
        }
    }
}

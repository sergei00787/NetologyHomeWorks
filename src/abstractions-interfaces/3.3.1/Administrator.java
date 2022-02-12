public interface Administrator extends Human{
    int searchBook(String book);
    void giveBook(Reader reader, int bookId);
    void overdueNotification(Reader readers);
}

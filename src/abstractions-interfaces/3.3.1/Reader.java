public interface Reader extends Human{
    void takeBook(String book, Administrator administrator);
    void returnBook(int bookId, Administrator administrator);
}

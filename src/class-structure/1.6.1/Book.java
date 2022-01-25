import java.time.LocalDate;

public class Book {
    private final int isbn;
    private final String title;
    private final String numberEdition;
    private final Author author;
    private final LocalDate yearPublishing;
    private final int pageCount;
    private final String text;

    public Book(int isbn, String title, String numberEdition, Author author, LocalDate yearPublishing, int pageCount, String text) {
        this.isbn = isbn;
        this.title = title;
        this.numberEdition = numberEdition;
        this.author = author;
        this.yearPublishing = yearPublishing;
        this.pageCount = pageCount;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", numberEdition='" + numberEdition + '\'' +
                ", author=" + author +
                ", yearPublishing=" + yearPublishing +
                ", pageCount=" + pageCount +
                ", text='" + text + '\'' +
                '}';
    }

    public void read() throws InterruptedException {
        int i = 0;
        while (i < text.length()) {
            Thread.sleep(50);
            System.out.print(this.text.charAt(i));
            i++;
        }
    }


}

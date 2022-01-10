import java.time.LocalDate;
import java.util.Arrays;

public class Book {
    private final int isbn;
    private final String title;
    private final String numberEdition;
    private final Author[] authors;
    private final LocalDate yearPublishing;
    private final int pageCount;
    private final String text;

    public Book(int isbn, String title, String numberEdition, Author[] authors, LocalDate yearPublishing, int pageCount, String text) {
        this.isbn = isbn;
        this.title = title;
        this.numberEdition = numberEdition;
        this.authors = authors;
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
                ", authors=" + Arrays.toString(authors) +
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

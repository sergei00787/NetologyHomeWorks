public class Book2 {
    int pageNumber;
    int yearProduction;

    public Book2(int pageNumber, int yearProduction) {
        this.pageNumber = pageNumber;
        this.yearProduction = yearProduction;
    }

    public static void main(String[] args) {
        Book2 book1 = new Book2(500, 2001);
        Book2 book2 = new Book2(500, 2001);
        if (book1.equals(book2)) System.out.println("Книги одинаковы");
    }

    public boolean equals(Book2 book) {
        return this.pageNumber == book.pageNumber && this.yearProduction == book.yearProduction;
    }

}

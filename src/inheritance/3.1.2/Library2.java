public class Library2 {
    public static void main(String[] args) {
        //Создадим первую книгу с тремя жанрами
        Book3 book1 = new Book3("Властелин колец", new Genre[] {new StoryGenre(), new ProseGenre(), new FantasticGenre()});
        //Создадим вторую книгу с двумя жанрами
        Book3 book2 = new Book3("Шерлок Холмс", new Genre[] {new NovelGenre(), new DetectiveGenre()});

        //Создадим объект \`BookService\` - для фильтрации
        BookService bookService = new BookService();

        //Вызовем метод фильтрации, куда передадим список книг и жанр фильтрации в качестве аргументов
        bookService.filterBookByGenre(new Book3[]{book1, book2}, new StoryGenre());
        bookService.filterBookByGenre(new Book3[]{book1, book2}, new DetectiveGenre());
        bookService.filterBookByGenre(new Book3[]{book1, book2}, new NarrativeGenre());
        bookService.filterBookByGenre(new Book3[]{book1, book2}, new VerseGenre());
    }
}

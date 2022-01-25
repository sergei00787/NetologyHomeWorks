public class Book3 {
    private String title;
    private Genre[] genres;

    public Book3(String title, Genre[] genres) {
        this.title = title;
        this.genres = genres;
    }

    public Book3(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Genre[] getGenres() {
        return genres;
    }

    @Override
    public String toString() {
        return this.title;
    }
}

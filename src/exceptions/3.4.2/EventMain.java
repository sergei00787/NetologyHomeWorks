public class EventMain {

    public static void validEvent(Event event) {
        if (event.getTitle() == null || event.getReleaseYear() <= 0 || event.getAge() <= 0)
            throw new RuntimeException("Одно из полей объекта некорректно");
    }

    public static Movie[] getMovies() {
        return new Movie[]{
                new Movie("StarWars", 1995, 12),
                new Movie("Terminator", 1992, 18),
                new Movie("Avengers", 2019, 0)};
    }

    public static Theatre[] getTheatres() {
        return new Theatre[]{
                new Theatre("Муму", 2022, 12),
                new Theatre("Пиковая дама", 0, 18),
                new Theatre("Щелкунчик", 1990, 16)};
    }


    public static void main(String[] args) {
        for (Event event : getMovies()) {
            validEvent(event);
        }
        for (Event event : getTheatres()) {
            validEvent(event);
        }
        System.out.println("Все события корректны");
    }
}

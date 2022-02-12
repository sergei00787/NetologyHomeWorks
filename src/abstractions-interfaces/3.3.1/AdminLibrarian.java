public class AdminLibrarian implements Administrator, Librarian{
    private String name;

    public AdminLibrarian(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int searchBook(String book) {
        System.out.println("Администратор " + getName() + " ищет книгу " + book);
        System.out.println("Администратор " + getName() + " нашел книгу ее ID =" + 55);
        return 55;
    }

    @Override
    public void giveBook(Reader reader, int bookId) {
        System.out.println("Админ выдал книгу с ID=" + bookId + " для читателя " + reader.getName());
    }

    @Override
    public void overdueNotification(Reader reader) {
        System.out.println("Админ послал предупреждение читателю " + reader.getName());
    }

    @Override
    public void orderBook(Supplier supplier, int bookId) {
        System.out.println("Библиотекарь " + getName() + " заказал книгу c ID=" + bookId + " у поставщика " + supplier.getName());
    }
}

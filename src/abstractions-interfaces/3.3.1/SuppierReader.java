public class SuppierReader implements Supplier, Reader, Human{
    private String name;

    public SuppierReader(String name) {
        this.name = name;
    }

    @Override
    public void takeBook(String book, Administrator administrator) {
        System.out.println("Читатель " + this.getName() + " запросил книгу " + book + " у администратора " + administrator.getName());
        int bookId = administrator.searchBook(book);
        administrator.giveBook(this, bookId);
    }

    @Override
    public void returnBook(int bookId, Administrator adminisrtator) {
        System.out.println("Читатель возвращет книгу ID= " + bookId);
    }

    @Override
    public void supplyBook(int bookId) {
        System.out.println("Поставщик " + getName() +" принес книгу ID=" + bookId);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}

public class User2 {
    private String email;
    private String name;
    private String surname;
    public static int totalOnline = 0;

    public User2(String email, String name, String surname) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        totalOnline++;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}

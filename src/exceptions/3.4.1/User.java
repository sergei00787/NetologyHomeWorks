public class User {
    private String login;
    private String pasword;
    private String email;
    private int age;

    public User(String login, String pasword, String email, int age) {
        this.login = login;
        this.pasword = pasword;
        this.email = email;
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", pasword='" + pasword + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}

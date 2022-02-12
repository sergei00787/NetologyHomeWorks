import java.util.Scanner;

public class AccessMain {

    public static User[] getUsers() {
        User user1 = new User("Ivan", "superpass", "vano@mail.com", 12);
        User user2 = new User("Kolya", "superkolya", "kolyan@mail.com", 18);
        User user3 = new User("Petr", "superpatya", "petr@mail.com", 35);
        User user4 = new User("Margarita", "supermargo", "margo@mail.com", 71);
        User user5 = new User("Sofia", "supersofa", "sofa@mail.com", 54);
        return new User[]{user1, user2, user3, user4, user5};
    }

    public static User getUserByLoginAndPassword(String login, String pass) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (login.equals(user.getLogin()) && pass.equals(user.getPasword())) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.getAge() < 18) throw new AccessDeniedException("Access denied");
    }

    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        User user = getUserByLoginAndPassword(login, password);
        validateUser(user);

        System.out.println("Доступ предоставлен");
    }

}
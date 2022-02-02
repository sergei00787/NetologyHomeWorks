import java.util.ArrayList;
import java.util.Scanner;

public class ToDoSaver {
    private final ArrayList<String> listTask = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoSaver toDoSaver = new ToDoSaver();

        while (true) {
            printMenu();
            String selectedAction = scanner.nextLine();
            int actionNum = -1;
            try {
                actionNum = Integer.parseInt(selectedAction);
            } catch (NumberFormatException nfe) {
                System.out.println("Вы ввели не число. Попробуйте снова");
                continue;
            }

            switch (actionNum) {
                case 1:
                    System.out.println("Введите задачу для планирования:");
                    toDoSaver.addTask(scanner.nextLine());
                    break;
                case 2:
                    toDoSaver.printTasks();
                    break;
                case 3:
                    if (toDoSaver.getListTask().size() == 0) {
                        System.out.println("Список задач уже пуст");
                        break;
                    }
                    while (true) {
                        System.out.println("Введите индекс удаляемой задачи");
                        String strIndex = scanner.nextLine();
                        int indexTask = -1;
                        try {
                            indexTask = Integer.parseInt(strIndex);
                            if (indexTask - 1 >= toDoSaver.getListTask().size()) {
                                System.out.println("Вы ввели неверный индекс задачи. Попробуйте ввести его снова.");
                                continue;
                            }
                            toDoSaver.deleteTask(indexTask - 1);
                        } catch (NumberFormatException nfe) {
                            System.out.println("Вы ввели не число. Попробуйте снова");
                            continue;
                        }
                        break;
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Вы выбрали неверный номер действия. Попробуйте снова.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Добавить задачу");
        System.out.println("2. Вывести список задач");
        System.out.println("3. Удалить задачу");
        System.out.println("0. Выход");
    }

    public void addTask(String task) {
        listTask.add(task);
    }

    public void deleteTask(int index) {
        listTask.remove(index);
    }

    public void printTasks() {
        System.out.println("Список задач:");
        for (String str : listTask) {
            System.out.println(str);
        }
    }

    public ArrayList<String> getListTask() {
        return listTask;
    }
}

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ListStudentMain {
    public static void main(String[] args) {
        Set<Student> listStudent = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        String currentStudentStr;
        try {
            System.out.println("Введите информацию о студенте: \"ФИО, номер группы, номер студенческого билета\"");
            currentStudentStr = scanner.nextLine();
            while (!currentStudentStr.equals("end")) {
                String[] currentStudent = currentStudentStr.split(",");
                Student student = new Student(currentStudent[0].trim(), currentStudent[1].trim(), currentStudent[2].trim());
                if (!listStudent.add(student))
                    System.out.println("Студент с таким номером билета уже существует. Повторите ввод.");
                System.out.println("Введите информацию о студенте (для завершения работы программы введите \"end\"");
                currentStudentStr = scanner.nextLine();
            }

            System.out.println("Список студентов:");
            for (Student stud : listStudent) {
                System.out.println(stud);
            }

        } catch (IndexOutOfBoundsException indxEx) {
            System.out.println("Введен неверный формат записи студента");
        }


    }


}

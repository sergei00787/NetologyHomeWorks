import java.util.Scanner;

public class LeapYearGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputYear;
        int inputDayOfYear;
        int countAchievement = 0;
        while (true){
            System.out.println("Введите год в формате \"yyyy\" количество дней");
            inputYear = scanner.nextInt();
            inputDayOfYear = scanner.nextInt();
            if (calculateDayOfYear(inputYear) != inputDayOfYear) {
                System.out.println("Неправильно! В этом году " + calculateDayOfYear(inputYear) +" дней!");
                System.out.println("Набрано очков: " + countAchievement);
                return;
            }
            countAchievement++;
        }
    }

    private static int calculateDayOfYear(int inputYear) {
        int dayOfYear = 0;
        if (inputYear % 400 == 0 || (inputYear % 4 == 0 && inputYear %100 != 0)) {
            dayOfYear = 366;
        } else {
            dayOfYear = 365;
        }
        return dayOfYear;
    }

}

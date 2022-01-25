import java.util.Scanner;

public class wer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        System.out.println("Введите год в формате \"уууу\"");
        int year = scanner.nextInt();
        int numDays = daysAYear(year);
        System.out.println("Количество дней: " + numDays);
    }
    public static int daysAYear(int year) {
        int daysAYear = 0;
        if (year % 400 == 0) {
            daysAYear = 366;
        } else if (year % 100 ==0) {
            daysAYear = 365;
        } else if (year % 4 != 0) {
            daysAYear = 366;
        } else {
            daysAYear = 365;
        }
        return daysAYear;
    }

}

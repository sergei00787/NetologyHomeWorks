package src;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        System.out.println("Введите год в формате \"yyyy\"");
        Scanner scanner = new Scanner(System.in);
        int inputYear = scanner.nextInt();
        System.out.println("Количество дней " + calculateDayOfYear(inputYear));
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

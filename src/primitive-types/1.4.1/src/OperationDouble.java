package src;

import java.util.Scanner;

public class OperationDouble {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            printCommandRequest();
            String strRequestCommand = scanner.nextLine();
            int numRequestCommand;
            try {
                numRequestCommand = Integer.parseInt(strRequestCommand);
            } catch (NumberFormatException ex){
                System.out.println("Вы ввели не число, попробуйте еще раз");
                continue;
            }

            switch (numRequestCommand){
                case 1:
                    compareDoubleAndFloat(scanner);
                    break;
                case 2:
                    roundDouble(scanner);
                    break;
                case 3:
                    truncateTail(scanner);
                    break;
                default:
                    System.out.println("Нет такой команды с номером " + numRequestCommand + ". Попробуйте еще раз.");
                    continue;
            }
            break;
        }
    }

    private static void printCommandRequest() {
        System.out.println();
        System.out.println("Операции над double/float");
        System.out.println("1. Сравнить");
        System.out.println("2. Округлить");
        System.out.println("3. Отбросить дробную часть");
    }

    private static void truncateTail(Scanner scanner) {
        System.out.println("Введите число:");
        double num1 = scanner.nextDouble();
        System.out.println("Результат:");
        System.out.println((long) num1);
    }

    private static void roundDouble(Scanner scanner) {
        System.out.println("Введите число:");
        double num1 = scanner.nextDouble();
        System.out.println("Результат:");
        System.out.println(Math.round(num1));
    }

    private static void compareDoubleAndFloat(Scanner scanner) {
        double num1 = getNum(scanner, "Введите первое число:");
        float num2 = getNum(scanner, "Введите второе число:");
        final float threshold = 0.0000001F;

        float dif = num2 - (float) num1;
        System.out.println("Результат:");
        if (Math.abs(dif) < threshold){
            System.out.println("Числа равны");
        } else {
            if (dif > 0) {
                System.out.println("Второе число больше первого");
            } else if (dif < 0 ){
                System.out.println("Первое число больше второго");
            }
        }
    }

    private static float getNum(Scanner scanner, String phrase) {
        while(true){
            try {
                System.out.println(phrase);
                String str = scanner.nextLine();
                return Float.parseFloat(str);
            } catch (NumberFormatException nfe){
                System.out.println("Вы ввели неверное число, попробуйте еще раз");
                continue;
            }
        }
    }
}

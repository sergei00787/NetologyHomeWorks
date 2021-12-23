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

        System.out.println("Введите первое число:");
        //double num1 = scanner.nextDouble();
        double num1 = Double.MAX_VALUE;

        System.out.println("Введите второе число:");
        //float num2 = scanner.nextFloat();
        float num2 = Float.MAX_VALUE;

        float dif = num2 - (float) num1;
        System.out.println("Результат:");
        if (dif > 0) {
            System.out.println("Второе число больше первого");
        } else if (dif < 0 ){
            System.out.println("Первое число больше второго");
        } else {
            System.out.println("Числа равны");
        }
        System.out.println("FLOAT NUM1=" + (float) num1);
        System.out.println("FLOAT NUM2=" + num2);


    }

    private static void printCommandRequest() {
        System.out.println();
        System.out.println("Операции над double/float");
        System.out.println("1. Сравнить");
        System.out.println("2. Округлить");
        System.out.println("3. Отбросить дробную часть");
    }
}

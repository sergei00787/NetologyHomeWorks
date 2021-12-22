package src;

import java.util.Scanner;

public class Businessman {

    public static void main(String[] args) {
        int earnings = 0;    // доходы
        int spendings = 0;   // расходы
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогооблажения");

            String inputCommand = scanner.nextLine();

            if (inputCommand.equals("end")) {
                break;
            }

            switch (inputCommand) {
                case "1":
                    earnings = sumEarnings(scanner, earnings);
                    break;
                case "2":
                    spendings = sumSpendings(scanner, spendings);
                    break;
                case "3":
                    calculateAndPrintMinimalTax(earnings, spendings);
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
        System.out.println("Программа завершена!");
    }

    private static int sumSpendings(Scanner scanner, int currentSpendings) {
        System.out.println("Введите сумму дохода:");
        String moneyStr = scanner.nextLine();
        int money = Integer.parseInt(moneyStr);
        return currentSpendings + money;
    }

    private static int sumEarnings(Scanner scanner, int currentEarnings) {
        System.out.println("Введите сумму дохода:");
        String moneyStr = scanner.nextLine();
        int money = Integer.parseInt(moneyStr);
        return currentEarnings + money;
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        return Math.max(tax, 0);
    }

    public static int taxEarnings(int earnings) {
        int tax = earnings * 6 / 100;
        return Math.max(tax, 0);
    }

    private static void calculateAndPrintMinimalTax(int earnings, int spendings) {
        int taxEMS = taxEarningsMinusSpendings(earnings, spendings);
        int taxE = taxEarnings(earnings);

        String outMinimalTaxName;
        int outMinTax;
        int outOtherTax;
        int outEconomy;

        if (taxEMS > taxE) {
            outMinimalTaxName = "Мы советуем вам УСН доходы минус расходы";
            outMinTax = taxE;
            outOtherTax = taxEMS;
            outEconomy = taxEMS - taxE;
        } else if (taxEMS < taxE) {
            outMinimalTaxName = "Мы советуем вам УСН доходы";
            outMinTax = taxEMS;
            outOtherTax = taxE;
            outEconomy = taxE - taxEMS;
        } else {
            outMinimalTaxName = "Вы можете выбрать любой УСН, т.к. обе имеют одинаковую сумму налога";
            outMinTax = taxE;
            outOtherTax = taxEMS;
            outEconomy = 0;
        }

        System.out.println(outMinimalTaxName);
        System.out.println("Ваш налог составит:" + outMinTax + " рублей");
        System.out.println("Налог на другой системе:" + outOtherTax + " рублей");
        System.out.println("Экономия:" + outEconomy + " рублей");

    }

}

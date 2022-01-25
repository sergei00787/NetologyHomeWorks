import java.util.Scanner;

public class CalcOperationLong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Введите первое число (для выхода введите end)");
            String num1String = scanner.next().trim();
            if (num1String.equals("end")) break;

            long num1, num2;

            try{
                num1 = Long.parseLong(num1String);
            } catch(NumberFormatException nfe){
                System.out.println("Неверный формат числа. Попробуйте снова.");
                continue;
            }

            System.out.println("Введите второе число");
            String num2String = scanner.next().trim();

            try{
                num2 = Long.parseLong(num2String);
            } catch(NumberFormatException nfe){
                System.out.println("Неверный формат числа. Попробуйте снова.");
                continue;
            }

            Operation operation;

            while(true){
                System.out.println("Выберите операцию abs, div, div_round, pow");
                try {
                    operation = Operation.valueOf(scanner.next().toUpperCase().trim());
                } catch (IllegalArgumentException illegalArgumentException){
                    System.out.println("Вы ввели неверный оператор. Попробуйте снова");
                    continue;
                }
                break;
            }

            calculate(num1, num2, operation);
            System.out.println("-----------------------------------------------");
        }

    }

    private static void calculate(long value1, long value2, Operation operation) {
        switch (operation) {
            case ABS:
                System.out.printf("value1 abs = %s %n", Math.abs(value1));
                System.out.printf("value2 abs = %s %n", Math.abs(value2));
                break;
            case DIV:
                System.out.printf("div = %s %n", (double) value1 / value2);
                break;
            case DIV_ROUND:
                System.out.printf("round div = %s %n", Math.round((double) value1 / value2));
                break;
            case POW:
                System.out.printf("pow = %s %n", Math.pow(value1, value2));
                break;
        }
    }

    public enum Operation{
        DIV,
        ABS,
        DIV_ROUND,
        POW
    }
}

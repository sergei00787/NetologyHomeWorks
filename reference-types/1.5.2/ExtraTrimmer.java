import java.util.Scanner;

public class ExtraTrimmer {
    public static void main(String[] args) {
        System.out.println("Введите текст:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String result = extraTrim(input.trim());
        System.out.println("Пробелы удалены!");
        System.out.println(result);
    }

    private static String extraTrim(String input){
        return input.replaceAll("\\s+"," ").replaceAll("\\s(\\p{Punct})", "$1");
    }


}

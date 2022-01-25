import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название задачи и время на ее выполнение:");
        String input = scanner.nextLine();

        int duration = calculateTaskDuration(input);

        if (duration <= 0) {
            System.out.println("\"Формат введенных данных неверный\"");
        } else {
            System.out.printf("\"На задачу потребуется: %d ч.\"", duration);
        }
    }

    private static int calculateTaskDuration(String input) {

        String startTimeString =  findTimeAfterPhraseInSting("начинается в", input);
        String finishTimeString = findTimeAfterPhraseInSting("заканчивается в", input);

        if (startTimeString.equals("") || finishTimeString.equals("")){
            return -1;
        }

        int startTime;
        int finishTime;

        try {
            startTime = Integer.parseInt(startTimeString.trim());
            finishTime = Integer.parseInt(finishTimeString.trim());
        } catch (NumberFormatException ex){
            return -1;
        }

        return finishTime - startTime;

    }

    private static String findTimeAfterPhraseInSting(String phrase, String input) {
        int indexFirstTime = input.indexOf(phrase);
        if (indexFirstTime == -1) return "";

        String result;
        try{
            result = input.substring(indexFirstTime + phrase.length(), indexFirstTime + phrase.length() + 3);
        } catch (IndexOutOfBoundsException indexOutOfBoundsException){
            result = "";
        }
        return result;
    }



}

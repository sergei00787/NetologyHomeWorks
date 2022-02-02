import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PolskExprMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PolskExpression polskExpression = new PolskExpression();

        System.out.println("Введите математическое выражение:");
        String mathExpr = scanner.nextLine();
        String[] arrMathExpr = mathExpr.split(" ");

//        List<Integer> listNumbers = Arrays.stream(arrMathExpr).filter(el -> intTryParse(el)).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> listNumbers = Arrays.stream(arrMathExpr).filter(el -> Pattern.matches("-?\\d+", el)).map(Integer::parseInt).collect(Collectors.toList());
//        List<String> listOperator = Arrays.stream(arrMathExpr).filter(el -> !intTryParse(el)).collect(Collectors.toList());
        List<String> listOperator = Arrays.stream(arrMathExpr).filter(el -> !Pattern.matches("-?\\d+", el)).collect(Collectors.toList());

        for (int curNumber: listNumbers) {
            polskExpression.addNumber(curNumber);
        }

        for (String curOperator: listOperator) {
            polskExpression.addOperator(curOperator);
        }

        polskExpression.printPolskExpression();

    }

    public static boolean intTryParse(String str){
        try{
            Integer num = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }


}

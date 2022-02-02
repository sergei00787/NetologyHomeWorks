import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

public class PolskExpression {
    private Queue<Integer> numbers = new LinkedList<>();
    private Stack<String> operators = new Stack<>();

    public void addNumber(int number){
        numbers.add(number);
    }

    public void addOperator(String operator){
        operators.push(operator);
    }

    public void printPolskExpression(){
        while(!numbers.isEmpty()){
            System.out.print(numbers.poll()+ " ");
        }

        while(!operators.isEmpty()){
            System.out.print(operators.pop());
            if (!operators.isEmpty()) System.out.print(" ");
        }
    }
}

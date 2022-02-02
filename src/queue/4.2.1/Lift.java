import java.util.LinkedList;
import java.util.Queue;

public class Lift {
    private Queue<Integer> listFloor = new LinkedList<Integer>();
    private int waitDoorsInSeconds = 10;
    private int waitMoveInSeconds = 5;
    private int totalSeconds = 0;
    private int previousFloor = -1;

    public Queue getListFloor() {
        return listFloor;
    }


    public void addCurrentFloor(int currentFloor) {
        if (previousFloor != -1) {
            totalSeconds += Math.abs(currentFloor - previousFloor) * waitMoveInSeconds;
            totalSeconds += waitDoorsInSeconds;
        }
        listFloor.offer(currentFloor);
        previousFloor = currentFloor;
    }

    public void printHistoryLiftMove() {
        while (listFloor.peek() != null){
            System.out.print("Этаж " + listFloor.poll());
            if (listFloor.peek() != null) System.out.print(" -> ");
        }
        System.out.println();
        System.out.println("Время затраченное лифтом на маршрут =: " + totalSeconds + " с.");
    }
}

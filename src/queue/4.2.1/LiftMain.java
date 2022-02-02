import java.util.Scanner;

public class LiftMain {
    public static void main(String[] args) {
        Lift lift = new Lift();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Ожидаю ввода этажа: (для завершения введите 0)");
            int currentFloor = scanner.nextInt();
            if (currentFloor == 0){
                lift.printHistoryLiftMove();
                return;
            }
            if (currentFloor > 25 || currentFloor < 0){
                System.out.println("Такого этажа нет в доме");
                continue;
            }
             lift.addCurrentFloor(currentFloor);
        }

    }
}

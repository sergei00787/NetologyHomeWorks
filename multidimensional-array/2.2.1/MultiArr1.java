import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MultiArr1 {
    private final byte[][] colors;
    private byte[][] rotatedColors;
    Random random = new Random();

    public MultiArr1(int size) {
        colors = new byte[size][size];
        rotatedColors = new byte[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                colors[i][j] = (byte) Math.abs(random.nextInt(256));
            }
        }
    }

    public static void printMatrix(byte[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static byte[][] rotateColors(byte[][] colors){
        byte[][] result = new byte[colors.length][colors[0].length];

        for (int i = 0; i < colors.length ; i++) {
            for (int j = 0; j < colors[i].length; j++) {
                result[i][j] = colors[colors.length-1-j][i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MultiArr1 multiArr1 = new MultiArr1(8);

        System.out.println("Исходная матрица:");
        System.out.println();
        MultiArr1.printMatrix(multiArr1.colors);

        while(true) {
            System.out.println("Введите угол поворота кратный 90");
            Scanner scanner = new Scanner(System.in);
            int angle;
            try{
                 angle = scanner.nextInt();
            } catch (InputMismatchException ime){
                System.out.println("Ошибка в парсинге угла. Попробуйте снова.");
                continue;
            }

            if (angle % 90 == 0) {
                int itaration = angle / 90;
                multiArr1.rotatedColors = MultiArr1.rotateColors(multiArr1.colors);
                for (int i = 1; i < itaration ; i++) {
                    multiArr1.rotatedColors = MultiArr1.rotateColors(multiArr1.rotatedColors);
                }
                break;
            } else {
                System.out.println("Вы ввели угол не кратный 90");
            }
        }

        MultiArr1.printMatrix(multiArr1.rotatedColors);
    }


}

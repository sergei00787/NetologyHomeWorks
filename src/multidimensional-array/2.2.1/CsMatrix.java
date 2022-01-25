import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class CsMatrix {
    private final int RANGE = 257;
    private final int[][] colors;
    Random random = new Random();
    private int[][] rotatedColors;

    public int[][] getColors() {
        return colors;
    }

    public int[][] getRotatedColors() {
        return rotatedColors;
    }

    public void setRotatedColors(int[][] rotatedColors) {
        this.rotatedColors = rotatedColors;
    }

    public CsMatrix(int size) {
        colors = new int[size][size];
        rotatedColors = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                colors[i][j] = random.nextInt(RANGE);
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] rotateColors(int[][] colors, int angle) {
        int[][] result = new int[colors.length][colors[0].length];

        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i].length; j++) {
                switch (angle) {
                    case (90):
                        result[i][j] = colors[colors.length - 1 - j][i];
                        break;
                    case (180):
                        result[i][j] = colors[colors.length - 1 - i][colors.length - 1 - j];
                        break;
                    case (270):
                        result[i][j] = colors[j][colors.length - 1 - i];
                        break;
                    default:
                        result[i][j] = colors[i][j];
                        break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        CsMatrix multiArr1 = new CsMatrix(8);

        System.out.println("Исходная матрица:");
        System.out.println();
        CsMatrix.printMatrix(multiArr1.colors);

        while (true) {
            System.out.println("Введите угол поворота кратный 90 (можно отрицательный, можно несколько оборотов)");
            Scanner scanner = new Scanner(System.in);

            int angle;
            try {
                angle = scanner.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Ошибка в парсинге угла. Попробуйте снова.");
                continue;
            }

            if (angle % 90 == 0) {
                angle = calculateAngle(angle);
                multiArr1.rotatedColors = CsMatrix.rotateColors(multiArr1.colors, angle);
                break;
            } else {
                System.out.println("Вы ввели угол не кратный 90");
            }
        }

        CsMatrix.printMatrix(multiArr1.rotatedColors);
    }

    private static int calculateAngle(int angle) {
        if ((Math.abs(angle)) / 360 >= 1){
            angle = angle % 360;
        }
        if (angle < 0) {
            if (angle == -90) angle = 270;
            if (angle == -180) angle = 180;
            if (angle == -270) angle = 90;
        }
        return angle;
    }


}

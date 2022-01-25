public class MultyArr2 {
    public static final int SIZE = 5;
    public static final char EMPTY = '-';
    public static final char CROSS = 'X';
    public static final char ZERO = 'O';

    public static void main(String[] args) {
        String[] arr1 = new String[]{
                "O O O X O",
                "X X X X X",
                "O O O X O",
                "O O O X O",
                "O O O O X"};
        char[][] field1 = generateFieldByArrayString(arr1);
        printField(field1);
        if (isWin(field1, CROSS)) System.out.println("ПОБЕДИЛИ КРЕСТИКИ");
        System.out.println();

        String[] arr2 = new String[]{
                "O O O X O",
                "O O - X X",
                "O O O X O",
                "X O O X O",
                "O O O O X"};
        char[][] field2 = generateFieldByArrayString(arr2);
        printField(field2);
        if (isWin(field2, ZERO)) System.out.println("ПОБЕДИЛИ НОЛИКИ");
        System.out.println();

        String[] arr3 = new String[]{
                "X O O X O",
                "O X X X X",
                "O O X X O",
                "O O O X O",
                "O O O O X"};
        char[][] field3 = generateFieldByArrayString(arr3);
        printField(field3);
        if (isWin(field3, CROSS)) System.out.println("ПОБЕДИЛИ КРЕСТИКИ");
        System.out.println();

        String[] arr4 = new String[]{
                "O O O X O",
                "X X X O X",
                "O O O X O",
                "O X O X O",
                "O O O O X"};
        char[][] field4 = generateFieldByArrayString(arr4);
        printField(field4);
        if (!isWin(field4, ZERO)) System.out.println("НИКТО НЕ ПОБЕДИЛ");
        System.out.println();

        String[] arr5 = new String[]{
                "O X O X O",
                "X X X O X",
                "O O O X O",
                "- O - X O",
                "O O O O X"};
        char[][] field5 = generateFieldByArrayString(arr5);
        printField(field5);
        if (isWin(field5, ZERO)) System.out.println("ПОБЕДИЛИ НОЛИКИ");
    }

    private static char[][] generateFieldByArrayString(String[] arrHorizontalLine) {
        int size = arrHorizontalLine.length;
        char[][] field = new char[size][size];
        for (int i = 0; i < size; i++) {
            String[] arrChar = arrHorizontalLine[i].split(" ");
            for (int j = 0; j < arrChar.length; j++) {
                field[i][j] = arrChar[j].trim().charAt(0);
            }
        }
        return field;
    }

    public static boolean isWin(char[][] field, char player) {
        int horizontal;
        int vertical;
        int diagonal1 = 0;
        int diagonal2 = 0;

        for (int i = 0; i < field.length; i++) {
            horizontal = 0;
            vertical = 0;
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == player) horizontal++;
                if (field[j][i] == player) vertical++;
            }
            if (field[i][i] == player) diagonal1++;
            if (field[i][field[i].length - 1 - i] == player) diagonal2++;
            if (horizontal == SIZE || vertical == SIZE || diagonal1 == SIZE || diagonal2 == SIZE) return true;
        }

        return false;
    }

    public static void printField(char[][] field) {
        for (char[] row : field) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

}

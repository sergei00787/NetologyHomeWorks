import java.util.Scanner;

public class ProdCalc {
    private final String[] products = createProducts();
    private final int[] prices = createPrices();
    private final int[] productBasket = new int[products.length];
    private final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        ProdCalc prodCalc = new ProdCalc();

        System.out.println("Список возможных товаров для покупки");
        for (int i = 0; i < prodCalc.products.length; i++) {
            System.out.printf("%d. %s %d руб/шт", i+1, prodCalc.products[i], prodCalc.prices[i]);
            System.out.println();
        }

        prodCalc.insertBasket();
        prodCalc.printBasket();

    }

    private void printBasket() {
        int sum = 0;
        System.out.printf("%1$20s | %2$20s | %3$20s | %4$20s","Наименование товара", "Количество", "Цена/за.ед", "Общая стоимость");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------");
        for (int i = 0; i < productBasket.length ; i++) {
            if (productBasket[i] != 0) {
                sum += productBasket[i] * prices[i];
                System.out.printf("%1$20s | %2$20d | %3$20d | %4$20d", products[i], productBasket[i], prices[i], productBasket[i] * prices[i]);
                System.out.println();
            }
        }
        System.out.printf("%1$20s   %2$20s   %3$20s | %4$20d","","","Итого", sum);
    }

    private void insertBasket() {
        while (true) {
            System.out.println("Выберите товар и количество или введите \\`end\\`");
            String inputScanner = scanner.nextLine().trim();
            if ("end".equals(inputScanner)) break;
            String[] input = inputScanner.split(" ");
            if (input.length == 2) {
                try {
                    int indexProduct = Integer.parseInt(input[0].trim()) - 1;
                    int countProduct = Integer.parseInt(input[1].trim());
                    productBasket[indexProduct] = productBasket[indexProduct] + countProduct;
                } catch (NumberFormatException nfe){
                    System.out.println("Вы ввели не число. Попробуйте снова");
                    continue;
                } catch (ArrayIndexOutOfBoundsException aiobe){
                    System.out.println("Вы ввели неверный номер продукта. Попробуйте снова");
                    continue;
                }

            } else {
                System.out.println("Ввод некорректный. Попробуйте снова");
                continue;
            }
        }
    }

    public String[] createProducts() {
        return  new String[]{"iPhone", "iPhone", "Пылесос", "Стол", "Селедка" };
    }

    public int[] createPrices() {
        return new int[]{50000, 20, 10000, 3000, 300};
    }

}

import java.util.Scanner;

public class Calculator {

    // Метод, уточняющий название товара
    public static void askGoodName (Good good, Scanner scanner) {
        System.out.println("Введите название товара:");
        good.name = scanner.next();
    }

    // Метод, уточняющий стоимость товара
    public static void askGoodPrice (Good good, Scanner scanner) {
        System.out.println("Введите стоимость в формате \"руб.коп\":");
        while (!scanner.hasNextDouble()){
            scanner.next();
            System.out.println("Стоимость нужно ввести в формате \"руб.коп\":");
        }
        good.price = Math.round(scanner.nextDouble() * 100) / 100d;
    }

    // Метод добавления товара в корзину и считающий общую сумму товаров в корзине
    public static void addGoodToBasket (Good good) {
        // Добавляем запись о товаре в список покупок и считаем общую сумму списка;
        good.listOfGoods += String.format("%.2f руб. - %s\n", good.price, good.name);
        good.sum += good.price;
        System.out.printf("Товар \"%s\" стоимостью %.2f руб. добавлен в корзину.\n", good.name, good.price);
    }

    // Метод печати списка товаров в корзине
    public static void printBasket (Good good) {
        System.out.printf("Добавленные товары:\n%s------\n%.2f руб. - сумма всех товаров.\n", good.listOfGoods, good.sum);
    }
}

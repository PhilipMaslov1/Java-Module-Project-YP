import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int numberOfPerson; // Количество участников.
        Scanner scanner = new Scanner(System.in);

        // Устанавливаем параметры для приёма и вывода "." вместо ",".
        Locale.setDefault(Locale.US);
        scanner.useLocale(Locale.US);

        // Спрашиваем у пользователя на сколько людей делить счёт.
        System.out.println("Укажите количество людей (шт.): ");
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Нужно ввести количество в шт. (Вы ввели \"" + scanner.next() + "\")");
            }
            numberOfPerson = scanner.nextInt();
            if (numberOfPerson <= 1)
                System.out.println("Количество должно быть больше 1. Повторите ввод.");
            else
                break;
        } while (true);

        // Создаём корзину товаров и спрашиваем, какие товары в неё добавить, какова их стоимость.
        // Выводим список товатов и долю(и) участников в общем счёте.
        Good good = new Good();
        while (true) {
            Calculator.askGoodName(good, scanner); // Уточняем наименование товара.
            Calculator.askGoodPrice(good, scanner); // Уточняем стоимость товара.
            Calculator.addGoodToBasket(good); // Добавляем товар в корзину.

            System.out.println("Добавить ещё один товар?"); // Уточняем, хочет ли пользователь что-то ещё добавить в корзину.
            if (scanner.next().equalsIgnoreCase("Завершить")) {
                Calculator.printBasket(good); // Печатаем состав корзины и её стоимость.
                Formatter.resultOfDividing(good, numberOfPerson); // Считаем долю каждого участника.
                break;
            }
        }
    }
}
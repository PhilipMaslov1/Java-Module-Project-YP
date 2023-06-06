import java.util.Locale;
import java.util.Scanner;

// TODO ToDo: нужно добавить обработку переполнений при считывании числовых значений и выполнении математических операций.

public class ConsoleReader {

    public static Scanner scanner = new Scanner(System.in);
    static int askNumberOfPerson () {
        int numberOfPerson;
        do {
            System.out.println("Укажите количество людей (шт.): ");
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.err.print("Нужно ввести число.\n");
                System.out.println("Укажите количество людей (шт.): ");
            }
            numberOfPerson = scanner.nextInt();
            if (numberOfPerson <= 1) {
                System.err.println("Количество должно быть больше 1");
            } else {
                return numberOfPerson;
            }
        } while (true);
    }
    static String askProductName () {
        String name;
        System.out.println("Введите название товара:");
        name = scanner.next();
        return name;
    }
    static double askProductPrice () {
        scanner.useLocale(Locale.US);
        double price;
        do {
            System.out.println("Введите стоимость в формате \"руб.коп\":");
            while (!scanner.hasNextDouble()){
                scanner.next();
                System.err.println("Не верный формат значения.");
                System.out.println("Введите стоимость в формате \"руб.коп\":");
            }
            price = scanner.nextDouble();
            if (Calculator.roundDouble(price) <= 0) {
                System.err.println("Стоимость должна быть больше нуля.");
            } else {
                return Calculator.roundDouble(price);
            }

        } while (true);
    }
    static boolean askToAddProduct(){
        System.out.println("\nДобавить ещё один товар?\n\"Да (или любой символ)\" - добавить товар,\n\"Завершить\" - закончить ввод и посчитать сумму.");
            if (scanner.next().equalsIgnoreCase("Завершить")) {
                return true;
            } else {
                return false;
            }
    }
    static void scannerClose (){
        scanner.close();
    }
}

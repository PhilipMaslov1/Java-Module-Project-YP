public class Bill {
    int numberOfPerson = 1; //Количество участников (по умолчанию 1)
    String listOfProducts = ""; // Список продуктов в корзине
    double sum = 0; // Стоимость всех продуктов в корзине

    void setNumberOfPerson () {
        this.numberOfPerson = ConsoleReader.askNumberOfPerson();
    }
    void addProduct (Product product) {
        listOfProducts += String.format("%.2f руб. - %s\n", product.price, product.name);
        sum += product.price;
        System.out.printf("Товар \"%s\" стоимостью %.2f руб. добавлен в корзину.\n", product.name, product.price);
    }
    void printBill() {
        System.out.printf("\nДобавленные товары:\n------\n%s------\n%.2f руб. - сумма всех товаров.\n\n", this.listOfProducts, this.sum);
    }

    // Метод выводит сообщение с долей каждого участника.
    // Если сумма не может быть разделена поровну,
    // считаем сколько должен заплатить каждый участник (в максимально равных долях).
    void printParticipantAmount () {
        double sumPerPerson = Calculator.getSumPerPerson(this);
        double remOfDivision = Calculator.getRemOfDivision(this);
        double lastParticipantPart = sumPerPerson + remOfDivision;

        if (Calculator.getRemOfDivision(this) == 0)
            System.out.printf("Счёт можно разделить поровну.\nКаждый должен заплатить по %.2f %s", sumPerPerson, Formatter.endOfRoubles(sumPerPerson));
        else {
            System.out.print("Счёт ровно не делится:");
            System.out.printf("\n- доля %d из %d людей составит %.2f %s", numberOfPerson - 1, numberOfPerson, sumPerPerson, Formatter.endOfRoubles(sumPerPerson));
            System.out.printf("\n- доля одного составит %.2f %s\n", lastParticipantPart, Formatter.endOfRoubles(lastParticipantPart));
        }
    }
}
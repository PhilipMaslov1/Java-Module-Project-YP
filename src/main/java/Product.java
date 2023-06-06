public class Product {
    String name; // Название продукта
    double price; // Цена продукта

    void setName () {
        this.name = ConsoleReader.askProductName();
    }
    void setPrice (){
        this.price = ConsoleReader.askProductPrice();
    }
}

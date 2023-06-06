public class Main {
    public static void main(String[] args) {

        Bill bill = new Bill();
        bill.setNumberOfPerson();

        while (true) {
            Product product = new Product();
            product.setName();
            product.setPrice();
            bill.addProduct(product);
            if (ConsoleReader.askToAddProduct()) {
                bill.printBill();
                bill.printParticipantAmount();
                ConsoleReader.scannerClose();
                break;
            }
        }
    }
}
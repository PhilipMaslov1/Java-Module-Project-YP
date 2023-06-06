public class Calculator {
    static double getSumPerPerson(Bill bill){
        return Math.round(bill.sum / bill.numberOfPerson * 100) / 100.0;
    }
    static double getRemOfDivision(Bill bill) {
        double sumPerPerson = Calculator.getSumPerPerson(bill);
        return Math.round((bill.sum - sumPerPerson * bill.numberOfPerson) * 100) / 100.0;
    }
    static double roundDouble (Double d) {
        return Math.round(d * 100) / 100d;
    }
}

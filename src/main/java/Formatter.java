public class Formatter {

    // Метод возвращает слово "рубль" с окончанием, в зависимости от суммы.
    static String endOfRoubles (double sum) {
        int intSum = (int) Math.floor(sum);
        return  switch (intSum - 10 * (intSum / 10)) {
            case 1 -> "рубль.";
            case 2, 3, 4 -> "рубля.";
            case 5, 6, 7, 8, 9, 0 -> "рублей.";
            default -> "руб.";
        };
    }
}
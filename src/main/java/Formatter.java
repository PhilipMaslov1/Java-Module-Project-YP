public class Formatter {

    // Метод возвращает слово "рубль" с окончанием, в зависимости от суммы.
    public static String endOfRoubles (double sum){
        switch ((int) Math.floor(sum) - 10 * ((int) Math.floor(sum) / 10)) {
            case 1:
                return "рубль.";
            case 2:
            case 3:
            case 4:
                return "рубля.";
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 0:
                return "рублей.";
            default:
                return "руб.";
        }
    }

    // Метод выводит сообщение с долей каждого участника.
    public static void resultOfDividing (Good good, int numberOfPerson) {
        double sumPerPerson = Math.round(good.sum / numberOfPerson * 100) / 100.0;
        double remOfDivision = Math.round((good.sum - sumPerPerson * numberOfPerson) * 100) / 100.0;

        // Если сумма не может быть разделена поровну, считаем сколько должен заплатить каждый участник в максимально равных долях.
        if (remOfDivision == 0)
            System.out.printf("Счёт можно разделить поровну.\nКаждый должен заплатить по %.2f %s", sumPerPerson, Formatter.endOfRoubles(sumPerPerson));
        else {
            System.out.printf("Счёт ровно не делится.\nДоля %d из %d людей составит %.2f %s", numberOfPerson - 1, numberOfPerson, sumPerPerson, Formatter.endOfRoubles(sumPerPerson));
            System.out.printf("Доля одного составит %.2f %s", sumPerPerson + remOfDivision, Formatter.endOfRoubles(sumPerPerson + remOfDivision));
        }
    }
}

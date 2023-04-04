
// класс для представления римских чисел
public class RomanNumeral {

    // арабская интерпретация римского числа
    private int arabicNumeral;

    // массивы для перевода из арабской системы в римскую (и наоборот)
    private static final int[] numbers =     {100,   90,  50,   40,  10,    9,  5,   4,     1};
    private static final String[] letters =  {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    // конструктор
    public RomanNumeral(String romanNumber) {
        if (romanNumber.length() == 0 || !isRomanNumber(romanNumber)) {
            throw new NumberFormatException("Wrong input of roman expression!");
        }

        int i = 0;
        // цикл для перевода римского числа в арабский вид
        while (i < romanNumber.length()) {
            char letter = romanNumber.charAt(i);
            int number = letterToArabicNumeral(letter);

            i++;
            if (i == romanNumber.length()) {
                arabicNumeral += number;
            }
            else {
                int nextNumber = letterToArabicNumeral(romanNumber.charAt(i));
                if (nextNumber > number) {
                    arabicNumeral += (nextNumber - number);
                    i++;
                }
                else {
                    arabicNumeral += number;
                }
            }
        }
    }

    // метод для сопоставления римских и арабских символов
    private int letterToArabicNumeral(char letter) {
        return switch (letter) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            default -> 0;
        };
    }


    // метод для перевода римского числа в строку
    public String toString() {
        StringBuilder romanNumeral = new StringBuilder();
        boolean positive = arabicNumeral >= 0;
        if (!positive || arabicNumeral == 0) {
            throw new NumberFormatException("Roman numbers have only positive values!");
        }
        int temp = arabicNumeral;
        // цикл для перевода числа в римский вид
        for (int i = 0; i < numbers.length; i++) {
                for (; temp >= numbers[i]; temp -= numbers[i]) {
                    romanNumeral.append(letters[i]);
                }
        }
        return romanNumeral.toString();
    }

    // аналогичный метод, но с аргументом
    public static String toString(int arabicNumeral) {
        StringBuilder romanNumeral = new StringBuilder();
        boolean positive = arabicNumeral >= 0;
        if (!positive || arabicNumeral == 0) {
            throw new NumberFormatException("Roman numbers have only positive values!");
        }

        int temp = arabicNumeral;
        for (int i = 0; i < numbers.length; i++) {
            for (; temp >= numbers[i]; temp -= numbers[i]) {
                romanNumeral.append(letters[i]);
            }
        }
        return romanNumeral.toString();
    }

    // перевод римского числа в арабский вид
    public int toInt() {
        return arabicNumeral;
    }

    // проверка, является ли входная строка римским числом
    static boolean isRomanNumber(String number) {
        char[] temp = number.toCharArray();
        for (char c : temp) {
            for (int j = 0; j < letters.length; j++) {
                if (letters[j].equals(String.valueOf(c))) {
                    break;
                }
                if (j == letters.length - 1) {
                    return false;
                }
            }
        }
        // проверка на то, что нет 4-х подряд идущих одинаковых символов
        for (int i = 3; i < temp.length; i++) {
            boolean b1 = temp[i - 3] == temp[i - 2];
            boolean b2 = temp[i - 2] == temp[i - 1];
            boolean b3 = temp[i - 1] == temp[i];
            if (b1 && b2 && b3) {
                throw new NumberFormatException("Wrong input of Roman number!");
            }
            // проверка на то, что если есть 3 подряд идущих одинаковых символа, то они обязательно
            // идут после большего числа
            if (b1 && b2) {
                RomanNumeral first = new RomanNumeral(String.valueOf(temp[i - 1]));
                RomanNumeral second = new RomanNumeral(String.valueOf(temp[i]));
                if (first.toInt() < second.toInt()) {
                    throw new NumberFormatException("Wrong input of Roman number!");
                }
            }
        }
        return true;
    }
}

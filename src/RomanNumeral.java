public class RomanNumeral {

    private int arabicNumeral;

    private static final int[] numbers =     {100,   90,  50,   40,  10,    9,  5,   4,     1};
    private static final String[] letters =  {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public RomanNumeral(String romanNumber) {
        if (romanNumber.length() == 0 || !isRomanNumber(romanNumber)) {
            throw new NumberFormatException("Wrong input of roman expression!");
        }

        int i = 0;
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

    public String toString() {
        StringBuilder romanNumeral = new StringBuilder();
        boolean positive = arabicNumeral >= 0;
        if (!positive || arabicNumeral == 0) {
            throw new NumberFormatException("Roman numbers have only positive values!");
        }

        for (int i = 0; i < numbers.length; i++) {
                for (int temp = arabicNumeral; temp >= numbers[i]; temp -= numbers[i]) {
                    romanNumeral.append(letters[i]);
                }
        }
        return romanNumeral.toString();
    }

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

    public int toInt() {
        return arabicNumeral;
    }

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
        for (int i = 3; i < temp.length; i++) {
            boolean b1 = temp[i - 3] == temp[i - 2];
            boolean b2 = temp[i - 2] == temp[i - 1];
            boolean b3 = temp[i - 1] == temp[i];
            if (b1 && b2 && b3) {
                throw new NumberFormatException("Wrong input of Roman number!");
            }
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

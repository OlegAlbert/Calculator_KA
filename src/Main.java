// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Это программа "калькулятор", выполненная в качестве тестового задания
// для Kata Academy. Программа считывает строку с выражением, проверяет
// корректность этого выражения, вычисляет результат и выводит в консоль.
// Программа работает с римскими и арабскими цифрами
public class Main {
    public static void main(String[] args) {
        // считываем строку с выражением
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter an expression like a + b where a and b - operands (can be Roman numerals), \nand " +
                    "(+, -, /, *) - operators; there are must be spaces between operators and operand:");

            String expression = reader.readLine();
            // с помощью метода calc() вычисляем выражение и получаем его результат в виде строки
            System.out.println(calc(expression));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    // метод вычисления выражения с возвратом результата в виде строки
    public static String calc(String input) {
        // если выражение пустое, то выбрасываем исключение
        if (input.length() == 0) {
            throw new NumberFormatException("Wrong input of expression!");
        }
        // проверяем первую цифру выражения: если она арабская, то вычисляем выражение с арабскими числами,
        // если римская - вычисляем выражение с римскими числами
        if (ArabicExpression.isArabicNumber(input.substring(0, 1))) {
            ArabicExpression expression = new ArabicExpression(input);
            return expression.solveArabicExpression();
        }
        else if (RomanNumeral.isRomanNumber(input.substring(0, 1))) {
            RomanExpression expression = new RomanExpression(input);
            return expression.solveRomanExpression();
        }
        // если первый символ не определен как римская или арабская цифра, то
        // бросаем исключение
        else {
            throw new NumberFormatException("Wrong input of expression");
        }
    }
}
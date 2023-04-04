// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter an expression like a + b where a and b - operands (can be Roman numerals), \nand " +
                    "(+, -, /, *) - operators; there are must be spaces between operators and operand:");

            String expression = reader.readLine();
            System.out.println(calc(expression));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static String calc(String input) {
        if (input.length() == 0) {
            throw new NumberFormatException("Wrong input of expression!");
        }
        if (ArabicExpression.isArabicNumber(input.substring(0, 1))) {
            ArabicExpression expression = new ArabicExpression(input);
            return expression.solveArabicExpression();
        }
        else if (RomanNumeral.isRomanNumber(input.substring(0, 1))) {
            RomanExpression expression = new RomanExpression(input);
            return expression.solveRomanExpression();
        }
        else {
            throw new NumberFormatException("Wrong input of expression");
        }
    }
}
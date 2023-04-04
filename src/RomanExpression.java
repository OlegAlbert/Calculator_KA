// класс для представления выражения с римскими числами
public class RomanExpression extends Expression {

    // переменные для хранения римских чисел
    private final RomanNumeral first;
    private final RomanNumeral second;

    // констркутор для римского выражения
    public RomanExpression(String expression) {
        // делим строку с помощью конструктора из абстрактного класса
        super(expression);

        // представляем операнды в римский вариант
        first = new RomanNumeral(firstOperand);
        second = new RomanNumeral(secondOperand);
        if (first.toInt() > 10 || first.toInt() < 0 ||
            second.toInt() > 10 || second.toInt() < 0) {
            throw new NumberFormatException("Operands must be between 0 and 10!");
        }
    }

    // решение выражения с римскими числами
    public String solveRomanExpression() {
        int oper1 = first.toInt();
        int oper2 = second.toInt();
        int result = -1;
        switch (operation) {
            case ("+") -> result = oper1 + oper2;
            case ("-") -> result = oper1 - oper2;
            case ("*") -> result = oper1 * oper2;
            case ("/") -> result = oper1 / oper2;
            default -> System.out.println("Unknown error!");
        }
        // у римских чисел нет отрицательных (и нуля), поэтому проверка на то, что результат положительный
        if (result <= 0) {
            throw new NumberFormatException("Roman numbers have only positive values!");
        }
        return (RomanNumeral.toString(result));
    }
}

public class RomanExpression extends Expression {
    private RomanNumeral first;
    private RomanNumeral second;
    public RomanExpression(String expression) {
        super(expression);
        first = new RomanNumeral(firstOperand);
        second = new RomanNumeral(secondOperand);
        if (first.toInt() > 10 || first.toInt() < 0 ||
            second.toInt() > 10 || second.toInt() < 0) {
            throw new NumberFormatException("Operands must be between 0 and 10!");
        }
    }

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
        if (result <= 0) {
            throw new NumberFormatException("Roman numbers have only positive values!");
        }
        return (RomanNumeral.toString(result));
    }
}

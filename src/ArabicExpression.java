public class ArabicExpression extends Expression {

    public ArabicExpression(String expression) {
        super(expression);
        if (!isArabicNumber(firstOperand) || !isArabicNumber(secondOperand)) {
            throw new NumberFormatException("Wrong input of arabic expression!");
        }

        if (Integer.parseInt(firstOperand) > 10 || Integer.parseInt(firstOperand) < 0 ||
            Integer.parseInt(secondOperand) > 10 || Integer.parseInt(secondOperand) < 0) {
            throw new NumberFormatException("Operands must be between 0 and 10!");
        }
    }

    static boolean isArabicNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String solveArabicExpression() {
        int oper1 = Integer.parseInt(firstOperand);
        int oper2 = Integer.parseInt(secondOperand);
        int result = -1;
        switch (operation) {
            case ("+") -> result = oper1 + oper2;
            case ("-") -> result = oper1 - oper2;
            case ("*") -> result = oper1 * oper2;
            case ("/") -> result = oper1 / oper2;
            default -> System.out.println("Unknown error!");
        }
        return String.valueOf(result);
    }
}

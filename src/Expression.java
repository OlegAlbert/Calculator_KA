public abstract class Expression {
    protected String firstOperand;
    protected String secondOperand;
    protected String operation;

    static protected String[] validOperations = {"+", "-", "*", "/"};

    protected Expression() {

    }

    public Expression(String expression) {
        String[] temp = expression.split(" ");
        if (temp.length != 3) {
            throw new NumberFormatException("Wrong input of expression!");
        }
        firstOperand = temp[0];
        operation = temp[1];
        secondOperand = temp[2];
        if (!isOperation(operation)) {
            throw new NumberFormatException("Only +, -, *, / operators are allowed!");
        }
    }

    static boolean isOperation(String operation) {
        for (String temp : validOperations) {
            if (operation.equals(temp)) {
                return true;
            }
        }
        return false;
    }

    /*public String solveExpression(String expression) {
        return null;
    }*/
}

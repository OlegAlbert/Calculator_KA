
// абстрактный класс для хранения выражения
public abstract class Expression {
    // первый операнд в виде строки
    protected String firstOperand;
    // второй операнд в виде строки
    protected String secondOperand;
    // знак выражения
    protected String operation;

    // массив с доступными операциями
    static protected String[] validOperations = {"+", "-", "*", "/"};

    // пустой конструктор для абстрактного класса
    protected Expression() {

    }

    // конструктор для преобразования цельной строки на операнды и знак операции
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

    // метод для проверки, является ли символ доступной операцией
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

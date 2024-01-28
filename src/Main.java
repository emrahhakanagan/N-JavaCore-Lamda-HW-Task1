import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        Calculator calculator = Calculator.instance.get();

        int a = calculator.plus.apply(1, 2);
        int b = calculator.minus.apply(1, 1);

        try {
            int c = calculator.divide.apply(a, b); // Может возникнуть ArithmeticException
            calculator.println.accept(c);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }


        /*
         * Проблема !!!
         * Выводится ошибки нв консоль -->
         * Exception in thread "main" java.lang.ArithmeticException: / by zero
         * at Calculator.lambda$new$3(Calculator.java:13)
         * at Main.main(Main.java:10)
         *
         * Ошибка возникает при делении на ноль в выражении calc.divide.apply(a, b).
         * Деление на ноль недопустимо в арифметике и создает исключению ArithmeticException.
         *
         * Решение -->
         * Добавить проверку на ноль в операции деления в классе Calculator и
         * выбросить исключение с сообщением, в случае деления равен нулю.
         * В методе main обернуть вызов в блок try-catch для обработки возможного исключения.
         *
         *
         * */


    }

}
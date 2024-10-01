import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите выражение:");
        String input = scanner.nextLine();

        try {
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        scanner.close();
    }

    public static String calc(String input) throws Exception {
        String[] tokens = input.split(" ");

        if (tokens.length != 3) {
            throw new Exception("Неправильный формат ввода.");
        }

        int num1 = Integer.parseInt(tokens[0]);
        String operator = tokens[1];
        int num2 = Integer.parseInt(tokens[2]);

        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new Exception("Числа должны быть от 1 до 10 включительно.");
        }

        int result; // Изменяем на int для целочисленного результата

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    throw new Exception("Деление на ноль!");
                }
                result = num1 / num2; // Целочисленное деление
                break;
            default:
                throw new Exception("Неправильная операция: " + operator);
        }

        return String.valueOf(result);
    }
}

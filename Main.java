import java.util.*;

public class Main {
    private static final String[] ROMAN_NUMERALS = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = scanner.nextLine();

        try {
            String[] tokens = input.split(" ");
            if (tokens.length != 3) {
                throw new IllegalArgumentException("Ошибка: неправильный формат ввода");
            }

            int num1 = parseNumber(tokens[0]);
            int num2 = parseNumber(tokens[2]);
            String operator = tokens[1];

            int result;
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
                    result = num1 / num2;
                    break;
                default:
                    throw new IllegalArgumentException("Ошибка: неправильный оператор");
            }

            System.out.println(convertToOutputFormat(result, num1 < 0 || num2 < 0));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int parseNumber(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            return parseRomanNumber(token);
        }

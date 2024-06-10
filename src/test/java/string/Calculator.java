package string;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        System.out.print("문자열을 입력하세요: ");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Calculator calculator = new Calculator();

        System.out.println("계산 결과: " + calculator.calculate(input));
    }

    public int calculate(String input) {
        String[] values = input.split(" ");

        if (values.length == 0) {
            throw new IllegalArgumentException("수식을 입력해주세요.");
        }

        int[] operands = extractOperands(values);
        String[] operators = extractOperators(values);

        int result = operands[0];

        for (int i = 0; i < operators.length; i++) {
            result = calculate(result, operators[i], operands[i + 1]);
        }

        return result;
    }

    private int[] extractOperands(String[] values) {
        int[] operands = new int[values.length / 2 + 1];

        for (int i = 0; i < values.length; i += 2) {
            try {
                operands[i / 2] = Integer.parseInt(values[i]);
            } catch (Exception e) {
                throw new NumberFormatException("올바른 피연산자가 아닙니다.");
            }
        }

        return operands;
    }

    private String[] extractOperators(String[] values) {
        String[] operators = new String[values.length / 2];

        for (int i = 1; i < values.length; i += 2) {
            operators[i / 2] = values[i];
        }

        return operators;
    }

    private int calculate(int operand1, String operator, int operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("올바르지 않은 연산자입니다.");
        }
    }
}
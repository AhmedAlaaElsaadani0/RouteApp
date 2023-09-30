package com.aaa.LoginFacebook.CalculatorApp;

import java.util.Stack;

public class StackCalculator {

    public static double evaluateExpression(CharSequence expression) {
        Stack<Double> numberStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        int i = 0;
        while (i < expression.length()) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                StringBuilder numBuilder = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    numBuilder.append(expression.charAt(i));
                    i++;
                }
                numberStack.push(Double.parseDouble(numBuilder.toString()));
            } else if (isOperator(ch)) {
                while (!operatorStack.isEmpty() && hasHigherPrecedence(operatorStack.peek(), ch)) {
                    double num2 = numberStack.pop();
                    double num1 = numberStack.pop();
                    char operator = operatorStack.pop();
                    double result = performOperation(num1, num2, operator);
                    numberStack.push(result);
                }
                operatorStack.push(ch);
                i++;
            } else {
                i++; // Ignore non-numeric and non-operator characters
            }
        }

        while (!operatorStack.isEmpty()) {
            double num2 = numberStack.pop();
            double num1 = numberStack.pop();
            char operator = operatorStack.pop();
            double result = performOperation(num1, num2, operator);
            numberStack.push(result);
        }

        return numberStack.pop();
    }

    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == '√';
    }

    private static int getPrecedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
            case '√':
                return 3;
            default:
                return 0; // For parentheses or other non-operators
        }
    }

    private static boolean hasHigherPrecedence(char op1, char op2) {
        return getPrecedence(op1) >= getPrecedence(op2);
    }

    private static double performOperation(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return num1 / num2;
            case '^':
                return Math.pow(num1, num2);
            case '√':
                return Math.sqrt(num2); // Square root of num2
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}

import java.util.*;

public class CalculatorWithQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a math expression (e.g., 3 + 5 * (2 - 4)):");
        String input = scanner.nextLine();

        try {
            Queue<String> postfix = infixToPostfix(input);
            double result = evaluatePostfix(postfix);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error in expression: " + e.getMessage());
        }
    }

    // Convert infix to postfix using a queue
    public static Queue<String> infixToPostfix(String expression) {
        Queue<String> outputQueue = new LinkedList<>();
        LinkedList<String> operatorStack = new LinkedList<>();
        StringTokenizer tokens = new StringTokenizer(expression, "+-*/() ", true);

        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken().trim();
            if (token.isEmpty()) continue;

            if (isNumber(token)) {
                outputQueue.add(token);
            } else if (isOperator(token)) {
                while (!operatorStack.isEmpty() &&
                        precedence(operatorStack.peek()) >= precedence(token)) {
                    outputQueue.add(operatorStack.pop());
                }
                operatorStack.push(token);
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    outputQueue.add(operatorStack.pop());
                }
                if (!operatorStack.isEmpty() && operatorStack.peek().equals("(")) {
                    operatorStack.pop(); // Remove '('
                } else {
                    throw new IllegalArgumentException("Mismatched parentheses");
                }
            } else {
                throw new IllegalArgumentException("Unknown token: " + token);
            }
        }

        while (!operatorStack.isEmpty()) {
            String op = operatorStack.pop();
            if (op.equals("(")) throw new IllegalArgumentException("Mismatched parentheses");
            outputQueue.add(op);
        }

        return outputQueue;
    }

    // Evaluate a postfix expression using a queue
    public static double evaluatePostfix(Queue<String> postfixQueue) {
        Stack<Double> stack = new Stack<>();

        while (!postfixQueue.isEmpty()) {
            String token = postfixQueue.poll();
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                if (stack.size() < 2) throw new IllegalArgumentException("Invalid postfix expression");
                double b = stack.pop();
                double a = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            }
        }

        if (stack.size() != 1) throw new IllegalArgumentException("Invalid postfix expression");
        return stack.pop();
    }

    private static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private static int precedence(String op) {
        return switch (op) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 0;
        };
    }
}

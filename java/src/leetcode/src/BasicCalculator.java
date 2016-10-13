package main.java.algorithms.src;

/**
 * handle + - * / with * and / take precedence.
 */
public class BasicCalculator {

    public int calculate(String expr) {
        int cur = 0;
        int low;
        int hi;
        char op = '0';

        for (int i = 0; i < expr.length(); i++) {
            if (Character.isDigit(expr.charAt(i))) {
                cur = cur * 10 + (expr.charAt(i) - '0');
            } else if (expr.charAt(i) == '*' || expr.charAt(i) == '/') {
                hi = cur;
                op = expr.charAt(i);
            } else if (expr.charAt(i) == '+' || expr.charAt(i) == '-') {

            }

        }




        return 0;
    }

    public static void main(String[] args) {
        System.out.println("space is " + Character.isSpaceChar(' '));
        System.out.println("newline is " + Character.isSpaceChar('\n'));
    }
}

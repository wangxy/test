package main.java.algorithms.src;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * Created by xwang on 6/20/16.
 */
public class WaysToAddParenthesis {
    public List<Integer> compute(String expr) {
        int val = 0;
        List<Deque> prev = new ArrayList<Deque>();

        for (int i = 0; i < expr.length(); i++) {
            if (Character.isDigit(expr.charAt(i))) {
                val = val * 10 + (expr.charAt(i) - '0');
            } else {
                if (prev.size() == 0) {
                    Deque<String> res = new ArrayDeque<String>();
                    res.offerLast(String.valueOf(val));
                    res.offerLast(String.valueOf(expr.charAt(i)));
                    prev.add(res);
                } else {
                    List<Deque> cur = new ArrayList<Deque>();
                    for (Deque<String> x : prev) {
                        // case 1: push the value
                        Deque<String> y = new ArrayDeque<String>(x);
                        y.offerLast(String.valueOf(val));
                        y.offerLast(String.valueOf(expr.charAt(i)));
                        cur.add(y);

                        // case 2: compute result
                        String op = x.pollLast();
                        int val1 = Integer.parseInt(x.pollLast());
                        int res = compute (val1, val, op);
                        x.offerLast(String.valueOf(res));
                        x.offerLast(String.valueOf(expr.charAt(i)));
                        cur.add(x);
                    }
                    prev = cur;
                }
                val = 0;
            }
        }

        ArrayList<Integer> f = new ArrayList<Integer>();
        for (Deque<String> x : prev) {
            // add the last value to the stack
            x.offerLast(String.valueOf(val));

            int v2 = Integer.parseInt(x.pollLast());
            while (x.peekLast() != null) {
                String op = x.pollLast();
                int v1 = Integer.parseInt(x.pollLast());
                v2 = compute(v1, v2, op);
              }
            f.add(v2);
        }
        return f;
    }
    private int compute(int val1, int val2, String op) {
        if (op.equals("+")) {
            return val1 + val2;
        } else if (op.equals("-")) {
            return val1 - val2;
        } else if (op.equals("*")) {
            return val1 * val2;
        } else {
            return val1 / val2;
        }
    }

    public static void main(String[] args) {
        String val = "1+2-4*8";
        WaysToAddParenthesis x = new WaysToAddParenthesis();
        List<Integer> res = x.compute(val);
        System.out.println(Arrays.toString(res.toArray()));
    }
}

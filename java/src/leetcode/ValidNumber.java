package main.java.algorithms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xwang on 8/14/16.
 */
public class ValidNumber {
    public boolean isNumber(String num) {
        if (num == null || num.isEmpty()) {
            return false;
        }
        String[] tokens = num.trim().split("e");
        if (tokens.length > 2) {
            return false; // contains more than 1 e.
        }
        if (tokens.length == 2 && tokens[1].contains(".")) {
            return false;
        }
        if (tokens.length == 1) {
            return isValid(tokens[0]);
        } else {
            return isValid(tokens[0]) && isValid(tokens[1]);
        }
    }

    private boolean isValid(String num) {
        Pattern p = Pattern.compile("[+-]?(0|0\\.[0-9]+|[1-9][0-9]*(\\.[0-9]+)?)");
        Matcher m = p.matcher(num);
        return m.matches();
    }

    public static void main(String[] args) {
        ValidNumber vn = new ValidNumber();
        System.out.println(vn.isNumber(" 12 "));
        System.out.println(vn.isNumber("+abc"));
        System.out.println(vn.isNumber("+0."));
        System.out.println(vn.isNumber("+0e"));
        System.out.println(vn.isNumber("+0e-31"));
    }
}

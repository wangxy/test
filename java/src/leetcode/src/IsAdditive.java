package main.java.algorithms.src;

/**
 * Created by xwang on 6/27/16.
 */
public class IsAdditive {
    public boolean isAdditiveNumber(String num) {
        // 112358
        for (int len = 1; len <= num.length() - 2; len++) {
            if (num.charAt(len) == '0' && !num.startsWith(num.substring(0, len), len+1)) continue;
            long n1 = Long.parseLong(num.substring(0, len));

            for (int len2 = 1; len2 <= num.length() - len - 1; len2++) {
                if (num.charAt(len + len2) == '0') continue;

                long n2 = Long.parseLong(num.substring(len, len + len2));
                if (!num.startsWith(String.valueOf(n1 + n2), len + len2)) continue;
                if (num.length() == (len + len2 + String.valueOf(n1+n2).length())) {
                    return true;
                }
                if (isAdditiveNumber(num.substring(len))){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        IsAdditive ia = new IsAdditive();
        ia.isAdditiveNumber("101");

    }

}
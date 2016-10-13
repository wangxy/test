package main.java.algorithms.dp;

/**
 * Created by xwang on 9/13/16.
 */
public class WildcardMatchII {
    // pattern may contain ? or *
    // ? matches exactly 1 char
    // * matches 0 or 1 char
    public boolean match(String pattern, String str) {
        char[] pchar = pattern.toCharArray();
        int pLen = pchar.length;
        char[] schar = str.toCharArray();
        int sLen = schar.length;

        boolean[][] match = new boolean[pLen + 1][sLen + 1];
        // initialize first row;

        match[0][0] = true;
        // first row are all false except for the first cell

        for (int i = 1; i <= pLen; i++) {
            match[i][0] = pchar[i-1] == '*' && match[i - 1][0];
        }

        for (int i = 1; i <= pLen; i++) {
            for (int j = 1; j <= sLen; j++) {
                if (pchar[i-1] == '?' || pchar[i-1] == schar[j-1]) {
                    match[i][j] = match[i-1][j-1];
                } else if (pchar[i-1] == '*') {
                    match[i][j] = match[i-1][j] || match[i][j-1];
                } else {
                    match[i][j] = false;
                }
            }
        }
        return match[pLen][sLen];
    }

    public static void main(String[] args) {
        WildcardMatchII match2 = new WildcardMatchII();
        System.out.println(match2.match("?", "a"));
        System.out.println(match2.match("a?*", "abcd"));
    }


}

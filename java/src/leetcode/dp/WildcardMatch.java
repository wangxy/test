package main.java.algorithms.dp;

/**
 * Created by xwang on 7/13/16.
 */
public class WildcardMatch {
    public boolean match(String pattern, String str) {
        int pLen = pattern.length();
        int sLen = str.length();
        boolean[][] m = new boolean[sLen+1][pLen+1];

        // todo: normalize the pattern first. replace ** with * because they are the same.

        m[0][0] = true;
        for (int i = 0; i < pLen; i++) {
            // THIS IS NOT NEEDE!
            m[0][i+1] = pattern.charAt(i) == '*';
        }
        for (int i = 0; i < sLen; i++) {
            m[i+1][0] = false;
        }

        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < pLen; j++) {
                if (pattern.charAt(j) == '?' || pattern.charAt(j) == str.charAt(i)) {
                    m[i+1][j+1] = m[i][j];
                } else if (pattern.charAt(j) == '*') {
                    m[i+1][j+1] = m[i][j+1] | m[i+1][j];
                } else {
                    m[i+1][j+1] = false;
                }
            }
        }
        return m[sLen][pLen];
    }

    public static void main(String[] args) {
        WildcardMatch m = new WildcardMatch();
        System.out.println(m.match("*", "a"));
        System.out.println(m.match("*a", "a"));
        System.out.println(m.match("*b", "a"));


    }

}

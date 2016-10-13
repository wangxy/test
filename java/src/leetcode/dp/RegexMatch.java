package main.java.algorithms.dp;

/**
 * Regex may contains . or *.
 * . matches any character
 * * matches any number of character before it.
 * .* matches any substring
 *
 */
public class RegexMatch {

    public boolean match(String p, String s) {
        int pl = p.length();
        int sl = s.length();
        char[] pc = p.toCharArray();
        char[] sc = s.toCharArray();

        boolean[][] T = new boolean[sl + 1][pl + 1];
        T[0][0] = true;
        for (int i = 0; i < pl; i++) {
            if (pc[i] == '*') {
                T[0][i+1] = T[0][i-1]; // note that we assume p is valid. does not start with '*"
            }
        }

        for (int i = 0; i < sl; i++) {
            for (int j = 0; j < pl; j++) {
                if (sc[i] == pc[j] || pc[j] == '.') {
                    T[i + 1][j + 1] = T[i][j];
                } else if (pc[j] == '*') {
                    T[i + 1][j + 1] = T[i + 1][j - 1]; // assume * matches 0
                    if (pc[j - 1] == sc[i] || pc[j - 1] == '.') {
                        T[i + 1][j + 1] = T[i + 1][j + 1] | T[i][j + 1];
                    }
                }
            }
        }
        return T[sl][pl];
    }

    public static void main (String[] args) {
        RegexMatch m = new RegexMatch();
        System.out.println(m.match(".*", "abcd"));
        System.out.println(m.match("a.*", "abcd"));
        System.out.println(m.match("a.*d", "abcd"));
    }


}

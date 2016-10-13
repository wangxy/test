package main.java.algorithms.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xwang on 7/11/16.
 */
public class GenAllAbbrev {
    public List<String> genAbbrev(String word) {
        List<List<Integer>> ll = new GenAllCombination().genAll(word.length());

        List<String> res = new ArrayList<String>();
        for (List<Integer> l : ll) {
            String abbrev = abbrev(word, l);
            res.add(abbrev);
        }
        return res;

    }

    private String abbrev(String word, List<Integer> l) {
        char[] c = word.toCharArray();
        for (Integer x : l) {
            c[x] = '0';
        }
        int cur = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            if (Character.isDigit(c[i])) {
                cur++;
            } else {
                if (cur > 0) {
                    builder.append(cur);
                    cur = 0;
                }
                builder.append(c[i]);
            }
        }
        if (cur > 0) {
            builder.append(cur);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        List<String> allAbbrev = new GenAllAbbrev().genAbbrev("word");
        for (String s : allAbbrev) {
            System.out.println(s);
        }
    }
}

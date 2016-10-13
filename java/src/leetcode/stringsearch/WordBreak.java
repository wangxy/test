package main.java.algorithms.stringsearch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xwang on 9/14/16.
 */
public class WordBreak {
    public List<String> wordBreak(String s, Set<String> words) {
        List<String> res = new ArrayList<String>();
        aux (res, "", s, words);
        return res;
    }

    private void aux(List<String> res, String prefix, String s, Set<String> words){
        if (s == null || s.equals("")) {
            res.add(prefix);
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            String cur = s.substring(0, i);
            if (words.contains(cur)) {
                aux(res, prefix.equals("") ? cur : prefix + " " + cur, s.substring(i), words);
            }
        }
    }

    public static void main(String[] args) {
        Set<String> words = new HashSet<String>(Arrays.asList("cats", "dogs", "cat", "dog", "and", "sand"));
        WordBreak wb = new WordBreak();
        List<String> res = wb.wordBreak("catsanddogs", words);
        for (String x : res){
            System.out.println(x);
        }

    }

}

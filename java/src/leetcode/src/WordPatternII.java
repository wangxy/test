package main.java.algorithms.src;

import java.util.HashMap;
import java.util.Map;

/**
 *     Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

 Examples:
 pattern = "abab", str = "redblueredblue" should return true.
 pattern = "aaaa", str = "asdasdasdasd" should return true.
 pattern = "aabb", str = "xyzabcxzyabc" should return false.
 Notes:
 You may assume both pattern and str contains only lowercase letters.
 Created by xwang on 9/27/16.
 */
public class WordPatternII {
    // basic idea: build up a dictionary and try it

    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<Character, String>();
        Map<String, Character> rev = new HashMap<String, Character>();

        return matchAux(pattern, str, map, rev);
    }

    private boolean matchAux(String pattern, String str, Map<Character, String> dict, Map<String, Character> rev) {
        if (pattern.length() == 0 && str.length() == 0) {
            return true;
        }
        if (pattern.length() == 0 || str.length() == 0) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            if (dict.containsKey(pattern.charAt(i))) {
                String val = dict.get(pattern.charAt(i));
                if (str.startsWith(val)) {
                    if (matchAux(pattern.substring(1), str.substring(val.length()), dict, rev)) {
                        return true;
                    }
                } else {
                    return false;
                }
            } else {
                for (int j = 1; j <= str.length(); j++) {
                    if (rev.containsKey(str.substring(0, j))) {
                        continue;
                    }
                    dict.put(pattern.charAt(i), str.substring(0, j));
                    rev.put(str.substring(0, j), pattern.charAt(i));

                    if (matchAux(pattern.substring(1), str.substring(j), dict, rev)) {
                        return true;
                    }
                    rev.remove(str.substring(0, j));
                    dict.remove(pattern.charAt(i));
                }
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String p = "abba";
        String v = "catdogdogcat";
        WordPatternII wp = new WordPatternII();
        System.out.println(wp.wordPatternMatch(p, v));




    }


}

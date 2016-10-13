package main.java.algorithms.src;

import com.apple.jobjc.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 336. Palindrome Pairs  QuestionEditorial Solution  My Submissions
 Total Accepted: 12927
 Total Submissions: 56803
 Difficulty: Hard
 Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

 Example 1:
 Given words = ["bat", "tab", "cat"]
 Return [[0, 1], [1, 0]]
 The palindromes are ["battab", "tabbat"]
 Example 2:
 Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 */
public class PalindromePairs {
    public List<String[]> pp(String[] words) {
        Set<String> set = new HashSet<String>();
        for (String word: words) {
            set.add(word);
        }

        List<String[]> res = new ArrayList<String[]>();
        for (String word: words) {
            for (int i = 0; i < word.length(); i++) {
                if (isPalin(word.substring(word.length() - i))) {
                    StringBuilder sb = new StringBuilder(word.substring(0, word.length() - i));
                    String pr = sb.reverse().toString();
                    if (set.contains(pr) && !pr.equals(word)) {
                        res.add(new String[]{word, pr});
                    }
                }

                if (isPalin(word.substring(0, i))) {
                    StringBuilder sb = new StringBuilder(word.substring(i));
                    String pr = sb.reverse().toString();
                    if (set.contains(pr) && !pr.equals(word)) {
                        res.add(new String[]{word, pr});
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalin(String str) {
        if (str.length() <= 1) {
            return true;
        }

        int half = str.length()/2;
        for (int i = 0; i < half; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePairs pp = new PalindromePairs();
        List<String[]> res = pp.pp(new String[] {"a", "aa", "aaa", "bba", "baa"});
        for (String[] r : res) {
            System.out.println(r[0] + " " + r[1]);
        }

    }

}

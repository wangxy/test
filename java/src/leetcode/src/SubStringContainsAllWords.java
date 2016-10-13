package main.java.algorithms.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 30. Substring with Concatenation of All Words  QuestionEditorial Solution  My Submissions
 Total Accepted: 65275
 Total Submissions: 304077
 Difficulty: Hard
 You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

 For example, given:
 s: "barfoothefoobarman"
 words: ["foo", "bar"]

 You should return the indices: [0,9].
 (order does not matter).
 */
public class SubStringContainsAllWords {
    // basic idea, memorize the index of last failed point,
    // case 1: with offset X, find a start point, in the middle, find a word that is not in the set, we can skip all the indexes
    //     in between, X, X + 3, X + 6...
    // case 2: with offset X, find a word that occurred multiple times, should skip from X to the end of the first appearance of the word
    // case 3:

    public List<Integer> substringIdx(String s, String[] words) {
        // use sliding window
        int wCnt = words.length;
        int wLen = words[0].length();

        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String w: words) {
            if (map.containsKey(w)) {
                map.put(w, map.get(w) + 1);
            } else {
                map.put(w, 1);
            }
        }

        List<Integer> res = new ArrayList<Integer>();
        Map<String, List<Integer>> wordIdx = new HashMap<String, List<Integer>>();
        for (int i = 0; i < wLen; i++) {
            for (String w : words) {
                wordIdx.put(w, new ArrayList<Integer>());
            }

            // this will be used as an offset
            int idx = i;
            int wordCount = 0;
            while (idx <= s.length() - wLen) {
                String sub = s.substring(idx, idx + wLen);
                if (map.containsKey(sub)) {
                    if (!wordIdx.containsKey(sub)) {
                        wordIdx.put(sub, new ArrayList<Integer>());
                    }
                    wordIdx.get(sub).add(idx);
                    wordCount++;
                    if (wordIdx.get(sub).size() <= map.get(sub)) {
                        if (wordCount == wCnt) { // emit the result
                            res.add(idx - (wLen * wCnt - wLen));
                            String t = s.substring(idx - (wLen * wCnt - wLen), idx - (wLen * wCnt - wLen) + wLen);
                            wordIdx.get(t).remove(0); // remove the first index
                            wordCount--; // decrease the wordcount.
                        }

                    } else {
                        // some word occurred more than expected. remove all indexes before its first occurance
                        int minIdx = wordIdx.get(sub).get(0);
                        // Remove all indexes before the first index
                        for (String w : wordIdx.keySet()) {
                            Iterator iter = wordIdx.get(w).iterator();
                            while (iter.hasNext()) {
                                if ((Integer) iter.next() <= minIdx) {
                                    iter.remove();
                                    wordCount--;
                                }
                            }
                        }
                    }
                } else {
                    // found an invalid key clean up the counts
                    for (String key : wordIdx.keySet()) {
                        wordIdx.put(key, new ArrayList<Integer>());
                    }
                    wordCount = 0;
                }
                idx += wLen;
            }
        }
        System.out.println(Arrays.toString(res.toArray()));
        return res;
    }

    public static void main(String[] args) {
        SubStringContainsAllWords ss = new SubStringContainsAllWords();
        ss.substringIdx("wordgoodgoodgoodbestword", new String[] {"word", "good", "good", "best"});
    }
}

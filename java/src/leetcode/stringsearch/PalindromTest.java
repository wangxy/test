package main.java.algorithms.stringsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromTest {
    public List<List<Integer>> palindromePairs(String[] words) {
        char[][] charArr = new char[words.length][];
        for (int i = 0; i < words.length; i++) {
            charArr[i] = words[i].toCharArray();
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPalindrome(charArr, i, j)) {
                    result.add(Arrays.asList(i, j));
                }
                if (isPalindrome(charArr, j, i)) {
                    result.add(Arrays.asList(j, i));
                }

            }
        }

        return result;
    }

    private boolean isPalindrome(char[][] arr, int i, int j){
        char[] iarr = arr[i];
        char[] jarr = arr[j];
        for (int idx = 0; idx < (jarr.length + iarr.length)/2; idx++) {
            if (getChar(iarr, jarr, idx) != getChar(iarr, jarr, jarr.length + iarr.length - idx - 1)) {
                return false;
            }
        }
        return true;
    }

    private char getChar(char[] fst, char[] snd, int idx) {
        if (idx < fst.length) {
            return fst[idx];
        } else {
            return snd[idx - fst.length];
        }
    }


}
package main.java.algorithms.dp;

/**
 * Find the longest substring that contains unique chars.
 */
public class MaxIncrease {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int[] lengths = new int[s.length()];
        for (int i = 0; i < chars.length; i++) {
            lengths[i] = 1;
        }

        for (int i = 1; i < chars.length; i++) {
            int lookback = lengths[i-1];
            boolean found = false;
            for (int j = 0; j < lookback; j++) {
                int index = i - j - 1;
                // found a match, break here.
                if (chars[i] == chars[index]) {
                    lengths[i] = Math.max(lengths[i], i - index);
                    found = true;
                }
            }
            if (!found) {
                lengths[i] = Math.max(lengths[i], 1 + lengths[i-1]);
            }
        }
        int maxLen = 0;
        for (int i = 0; i < lengths.length; i++) {
            if (lengths[i] > maxLen) {
                maxLen = lengths[i];
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        MaxIncrease mi = new MaxIncrease();
        System.out.println(mi.lengthOfLongestSubstring("abc"));
    }
}
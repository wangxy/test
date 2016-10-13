package main.java.algorithms.combination;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LargestDividableSubSet {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        boolean[][] divisible = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (nums[j] % nums[i] == 0) {
                    divisible[i][j] = true;
                }
            }
        }
        return null;
    }

    public static void main(String[] args){
        Pattern p = Pattern.compile("^(?:\\d{1,3}\\.){3}\\d{1,3}$|^$");
        Matcher m = p.matcher("a: 1.1.1.1");
        if (m.find()) {
            System.out.println("Matches");
        } else {
            System.out.println("Not matches");
        }
    }
}
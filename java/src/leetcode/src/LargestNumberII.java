package main.java.algorithms.src;

import java.util.Arrays;

/**
 * Created by xwang on 5/25/16.
 */
public class LargestNumberII {

    public int[] largestSubSequence(int[] nums, int len) {
        int[] res = new int[len];

        int startIdx = 0;
        for (int i = 0; i < len; i++) {
            int maxIdx = getMaxIdx(nums, startIdx, nums.length - len + i);
            res[i] = nums[maxIdx];
            startIdx = maxIdx+1;
        }
        return res;

    }
    private int getMaxIdx(int[] nums, int startIdx, int endIdx) {
        int maxIdx = startIdx;
        for (int i = startIdx + 1; i <= endIdx; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    public static void main(String[] args) {
        int[] input = {5, 7, 3, 8, 4};
        LargestNumberII x = new LargestNumberII();

        System.out.println(Arrays.toString(x.largestSubSequence(input, 1)));

        System.out.println(Arrays.toString(x.largestSubSequence(input, 2)));
        System.out.println(Arrays.toString(x.largestSubSequence(input, 3)));
        System.out.println(Arrays.toString(x.largestSubSequence(input, 4)));


    }



}

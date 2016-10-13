package main.java;

import java.util.Arrays;

/**
 * Created by xwang on 9/8/16.
 */
public class KthElement {
    public int kth(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length - 1;
        while (true) {
            int idx = partition(nums, lo, hi);
            if (idx == nums.length - k) {
                return nums[idx];
            } else if (idx < nums.length - k) {
                lo = idx + 1;
            } else {
                hi = idx - 1;
            }
        }
    }

    public int partition(int[] nums, int lo, int hi) {
        int pivot = nums[hi];
        int i = 0;
        for (int j = 0; j < hi; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, hi);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args){
        KthElement ke = new KthElement();
        int[] nums = {9, 1, 4, 6, 10};
        int i = ke.kth(nums, 5);
        System.out.println(i + Arrays.toString(nums));
    }
}

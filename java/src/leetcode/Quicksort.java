package main.java;

import java.util.Arrays;

/**
 * Created by xwang on 9/8/16.
 */
public class Quicksort {

    public void quicksort(int[] nums) {
        aux(nums, 0, nums.length - 1);
    }

    private void aux(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int i = partition(nums, lo, hi);
        aux(nums, lo, i - 1);
        aux(nums, i + 1, hi);
    }

    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[hi];
        int i = lo;
        for (int j = 0; j < hi; j++){
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


    public static void main(String[] args) {
        int[] val = {10, 1, 4, 3, 9};
        Quicksort qs = new Quicksort();
        qs.quicksort(val);
        System.out.println(Arrays.toString(val));

    }
}

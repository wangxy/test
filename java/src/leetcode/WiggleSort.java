package main.java.algorithms;

import java.util.Arrays;

/**
 * Created by xwang on 6/16/16.
 */
public class WiggleSort {
        public void wiggleSort(int[] nums) {
            Arrays.sort(nums);
            // 1, 2, 3, 4, 5, 6,
            // 1, 6, 3, 5, 4, 2
            int swapIdx = nums.length - 1;
            for (int i = 0; i <= (nums.length + 1)/2; i++) {
                if (i % 2 == 1) {
                    swap(nums, i, swapIdx);
                    swapIdx--;
                }
            }
        }

        private void swap(int[] nums, int x, int y) {
            int tmp = nums[x];
            nums[x] = nums[y];
            nums[y] = tmp;
        }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4 ,5, 6, 7};
        // 1, 7, 3, 6, 4, 5, 2
        WiggleSort sort = new WiggleSort();
        sort.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));


    }

}

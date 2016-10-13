package main.java.algorithms.src;

/**
 * Created by xwang on 10/4/16.
 */
public class QuickSelect {
    public int quickSelect(int[] nums, int k){
        return select(nums, k, 0, nums.length - 1);
    }

    public int select(int[] nums, int k, int startIdx, int endIdx) {
        int pivot = nums[endIdx];
        int pos = startIdx;
        for (int i = startIdx; i < endIdx; i++) {
            if (nums[i] < pivot) {
                // move to front
                swap(nums, i, pos);
                pos++;
            }
        }
        swap(nums, pos, endIdx);
        if (pos > k) {
            return select(nums, k, startIdx, pos - 1);
        } else if (pos == k) {
            return nums[pos];
        } else {
            return select(nums, k, pos + 1, endIdx);
        }
    }

    private void swap(int[] nums, int x, int y){
        if (x == y) {return ;}
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    public static void main(String[] args) {
        QuickSelect qs = new QuickSelect();
        System.out.println(qs.quickSelect(new int[]{9, 3, 10, 6, 5, 7}, 1));
        System.out.println(qs.quickSelect(new int[]{9, 3, 10, 6, 5, 7}, 0));
        System.out.println(qs.quickSelect(new int[]{9, 3, 10, 6, 5, 7}, 3));
        System.out.println(qs.quickSelect(new int[]{9, 3, 10, 6, 5, 7}, 5));
    }
}

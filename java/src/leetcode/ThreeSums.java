package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xwang on 9/12/16.
 */
public class ThreeSums {
    public List<List<Integer>> threeSums(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> prefix = new ArrayList<Integer>();

        aux(result, prefix, nums, 0, 0);
        return result;
    }

    private void aux(List<List<Integer>> res, List<Integer> prefix, int[] nums, int start, int target) {
        if (prefix.size() == 3 && target == 0) {
            res.add(new ArrayList<Integer>(prefix));
            System.out.println(Arrays.toString(prefix.toArray()));
            return;
        }

        // end of the
        if (start >= nums.length) {
            return;
        }
        prefix.add(nums[start]);
        aux(res, prefix, nums, start + 1, target - nums[start]);
        prefix.remove(prefix.size() - 1);

        aux(res, prefix, nums, start + 1, target);
    }

    public static void main(String[] args) {
        ThreeSums ts = new ThreeSums();
        List<List<Integer>> res = ts.threeSums(new int[]{-1, 0, 1, 2, -2});


    }
}

package main.java.algorithms.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class generates all the combinations possible
 *
 */
public class Combination {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i <= k; i++) {
            res.addAll(aux(n, i, 0));
        }
        return res;
    }

    private List<List<Integer>> aux(int num, int n, int start) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }

        for (int i = start; i < num; i++) {
            List<List<Integer>> sub = aux(num, n - 1, i + 1);
            for (List<Integer> x : sub) {
                x.add(0, i);
                res.add(x);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Combination com = new Combination();
        List<List<Integer>> res = com.combine(4, 2);
        System.out.println(Arrays.toString(res.toArray()));
    }

}
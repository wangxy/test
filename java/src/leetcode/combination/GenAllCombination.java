package main.java.algorithms.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xwang on 7/11/16.
 */
public class GenAllCombination {
    public List<List<Integer>> genAll(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 1; i < n; i++) {
            aux(res, new ArrayList<Integer>(), i, n, 0);
        }

        return res;

    }

    private void aux(List<List<Integer>> res, List<Integer> num, int cnt, int n, int start) {
       if (cnt == 0) {
           res.add(new ArrayList<Integer>(num));
       }

        for (int i = start; i < n; i++) {
            num.add(i);
            aux(res, num, cnt - 1, n, i + 1);
            num.remove(num.size() - 1);
        }
    }
    public static void main(String[] args) {
        GenAllCombination com = new GenAllCombination();
        List<List<Integer>> ll = com.genAll(4);
        for (List<Integer> l : ll) {
            for (Integer i : l) {
                System.out.print(i + ",");
            }
            System.out.println();

        }

    }

}

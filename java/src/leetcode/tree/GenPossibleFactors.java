package main.java.algorithms.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * For each integer, it can be represented as the multiply of several integer.
 */
public class GenPossibleFactors {
    public List<List<Integer>> genFactors(int x) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        aux (result, new ArrayList<Integer>(), x, 2);
        return result;
    }

    private void aux(List<List<Integer>> result, List<Integer> cur, int val, int start) {
        if (val == 1) {
            if (cur.size() > 1) {
                result.add(new ArrayList<Integer>(cur));
            }
        }

        for (int i = start; i <= val; i++) {
            if (val % i == 0) {
                cur.add(i);
                aux(result, cur, val/i, i);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        GenPossibleFactors gpf = new GenPossibleFactors();
        List<List<Integer>> r = gpf.genFactors(12);
        for (List<Integer> l : r) {
            System.out.println(l.toString());
        }
        int x = 1;
        System.out.println(x-- > 0);
    }
}

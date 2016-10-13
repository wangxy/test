package main.java.algorithms.src;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * Created by xwang on 5/18/16.
 */
public class TestTreeMap {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return 0;
                    }
                }

        );

    tm.put(10, 2);
        tm.put(5, 10);
        tm.put(15, 4);

        System.out.println(tm.firstEntry().getKey() + " " + tm.firstEntry().getValue());
        int val = tm.remove(5);
        System.out.println("Removed value is: " + val);

        System.out.println(Arrays.asList(tm.keySet()));
        val = tm.remove(10);
        System.out.println("Removed value is: " + val);

        System.out.println(tm.size());



    }

}

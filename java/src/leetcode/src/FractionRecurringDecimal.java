package main.java.algorithms.src;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by xwang on 6/20/16.
 */
public class FractionRecurringDecimal {
    public String printDecimal(int nom, int demo) {
        Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
        int div = nom/demo;
        int remain = nom % demo;
        StringBuilder sb = new StringBuilder();
        sb.append(div);

        while (remain != 0 && !map.containsKey(remain)) {
            while (remain * 10 < nom) {
                map.put(remain, 0);
                remain = remain * 10;
            }
            div = remain * 10/demo;
            map.put(remain, div);
            remain = (remain * 10) % demo;
        }
        if (map.size() == 0) {
            return sb.toString();
        }
        sb.append(".");
        if (remain == 0) {
            // no recuring
            for (int key : map.keySet()) {
                sb.append(map.get(key));
            }
            return sb.toString();
        } else {
            for (int key : map.keySet()) {
                if (key == remain) {
                    sb.append("(");
                }
                sb.append(map.get(key));
            }
            sb.append(")");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        FractionRecurringDecimal fr = new FractionRecurringDecimal();
        System.out.println(fr.printDecimal(10, 7));
        System.out.println(10.0/7);

    }

}

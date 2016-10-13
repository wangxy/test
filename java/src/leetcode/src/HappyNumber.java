package main.java.algorithms.src;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> found = new HashSet<Integer>();
        int cur = n;
        if (cur == 1) {
            return true;
        } else {
            found.add(cur);
        }
        while(true) {
            System.out.println(cur);
            cur = sumSquare(cur);
            System.out.println("--> " + cur);
            if (cur == 1) {
                return true;
            } else {
                if (found.contains(cur)) {
                    return false;
                } else {
                    found.add(cur);
                }
            }
        }
    }

    private int sumSquare(int n) {
        int cur = n;
        int total = 0;
        while (cur > 0) {
            total += (cur % 10) * (cur % 10);
            cur = cur/10;
        }
        return total;
    }

    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();
        hn.isHappy(3);

    }
}
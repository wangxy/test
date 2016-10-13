package main.java.algorithms.src;

import java.util.Random;

/**
 * Created by xwang on 9/30/16.
 */
public class CoinChange {
    int[] coins = new int[]{1, 5, 10, 25, 50, 100};

    public int possibleWays(int amount) {
        if (amount <= 0) {
            return 0;
        }
        return aux(amount, 0);
    }

    private int aux(int amount, int startIdx) {
        if (amount == 0) {
            return 1;
        }
        if (startIdx >= 6) { return 0; }
        if (coins[startIdx] > amount) {
            return 0;
        }

        int cnt = 0;
        int curCnt = 0;
        while (true) {
            int remain = amount - coins[startIdx] * curCnt;
            if (remain < 0) {
                break;
            }
            cnt += aux(remain, startIdx+1);
            curCnt++;
        }
        return cnt;
    }

    // Q: can we use dynamic programming to solve this problem?

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        System.out.println(cc.possibleWays(0));
        System.out.println(cc.possibleWays(1));
        System.out.println(cc.possibleWays(2));
        System.out.println(cc.possibleWays(5));
        System.out.println(cc.possibleWays(25));
    }
}

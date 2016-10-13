package main.java.algorithms.dp;

import java.util.Arrays;

/**
 * Created by xwang on 7/13/16.
 */
public class SumMetrics {
    int[][] sum;

    public void sum(int[][] metric) {
        int m = metric.length;
        int n = metric[0].length;
        sum = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            sum[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            sum[0][i] = 0;
        }

        for (int i = 1; i < sum.length; i++) {
            for (int j = 1; j < sum[0].length; j++) {
                sum[i][j] = sum[i][j - 1] + metric[i-1][j-1] + sum[i-1][j] - sum[i-1][j-1];
            }
        }
        printMetric(metric);
        System.out.println("---------");
        printMetric(sum);
    }

    public int lookup(int rowMin, int colMin, int rowMax, int colMax) {
        return sum[rowMax+1][colMax+1] - sum[rowMax+1][colMin] - sum[rowMin][colMax+1] + sum[rowMin][colMin];
    }

    private void printMetric(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
    }
    public static void main(String[] args) {
        SumMetrics m = new SumMetrics();
        m.sum(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        System.out.println(m.lookup(0, 1, 1, 2));
    }

}

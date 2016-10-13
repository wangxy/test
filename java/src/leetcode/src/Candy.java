package main.java.algorithms.src;

/**
 * 135. Candy  QuestionEditorial Solution  My Submissions
 Total Accepted: 58823
 Total Submissions: 250765
 Difficulty: Hard
 There are N children standing in a line. Each child is assigned a rating value.

 You are giving candies to these children subjected to the following requirements:

 Each child must have at least one candy.
 Children with a higher rating get more candies than their neighbors.
 What is the minimum candies you must give?
 */
public class Candy {
    public int candy(int[] rating) {
        // 1, 10, 7, 4, 0
        // 1   1  1  1  1
        // 1   3  2  1  1
        // 1   4   3   2   1
        int l = rating.length;
        if (l <= 1) { return l; }

        int[] c = new int[l];
        for (int i = 0; i < l; i++) {
            c[i] = 1;
        }
        // from left to right,
        for (int i = 1; i < l; i++) {
            // from left to right. whenever a node is greater than its previous
            // increase the count.
            // what's missing? we didn't guarantee that
            if (rating[i] > rating[i-1]) {
                c[i] = c[i-1] + 1;
            }
        }
        // from right to left;
        c[l-1] = 1;
        for (int i = l-2; i >= 0; i--) {
            if (rating[i] > rating[i+1]) {
                c[i] = Math.max(c[i], c[i+1] + 1);
            }
        }

        int total = 0;
        for (int i = 0; i < l; i++) {
            System.out.println(c[i]);
            total += c[i];
        }
        return total;
    }

    public static void main(String[] args) {
        Candy c = new Candy();
        c.candy(new int[] {4, 2, 3, 4, 1});
    }
}

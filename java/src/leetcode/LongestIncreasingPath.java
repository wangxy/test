package main.java.algorithms;

/**
 * 329. Longest Increasing Path in a Matrix  QuestionEditorial Solution  My Submissions
 Total Accepted: 22467
 Total Submissions: 65861
 Difficulty: Hard
 Given an integer matrix, find the length of the longest increasing path.

 From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

 Example 1:

 nums = [
 [9,9,4],
 [6,6,8],
 [2,1,1]
 ]
 Return 4
 The longest increasing path is [1, 2, 6, 9].

 Example 2:

 nums = [
 [3,4,5],
 [3,2,6],
 [2,2,1]
 ]

 Return 4
 The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

 Credits:
 Special thanks to @dietpepsi for adding this problem and creating all test cases.
 *!!!!!!!!!!!!!!!
 *! note that the interesting part is if we can go to a path, then the current node must
 * not within the path of a previous, so that we can reuse the value computed previously.


 */
public class LongestIncreasingPath {
    public int getLongest(int[][] matrix) {
        // basic idea, from each node, explore it's all four directions and see what's the maximal length;
        int row = matrix.length;
        if (row == 0) { return 0; }
        int col = matrix[0].length;
        if (col == 0) { return 0; }

        int[][] cache = new int[row][col];
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(max, aux(matrix, cache, i, j, Integer.MIN_VALUE));
            }
        }
        return max;
    }

    private int aux(int[][] matrix, int[][] cache, int i, int j, int cur) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] <= cur) {
            // cannot go any further.
            return 0;
        }

        // this node has been explored previously.
        if (cache[i][j] > 0) {
            return cache[i][j];
        }

        int a = aux(matrix, cache, i-1, j, matrix[i][j]) + 1;
        int b = aux(matrix, cache, i+1, j, matrix[i][j]) + 1;
        int c = aux(matrix, cache, i, j-1, matrix[i][j]) + 1;
        int d = aux(matrix, cache, i, j+1, matrix[i][j]) + 1;

        int max = Math.max(Math.max(a, b), Math.max(c, d));
        cache[i][j] = max;
        return max;

    }

    public static void main(String[] args) {
        LongestIncreasingPath lip = new LongestIncreasingPath();
        System.out.println(lip.getLongest(new int[][] {
                {3, 4, 5},
                {1, 2, 6},
                {-10, -20, 1}}));


    }

}

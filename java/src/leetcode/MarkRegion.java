package main.java.algorithms;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by xwang on 7/11/16.
 */
public class MarkRegion {
    public void mark(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'o') {
                fill(board, i, 0, 'y');
            }
            if (board[i][col - 1] == 'o') {
                fill(board, i, col-1, 'y');
            }
        }
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'o') {
                fill(board, 0, i, 'y');

            }
            if (board[row - 1][i] == 'o') {
                fill(board, row - 1, i, 'y');
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'y') {
                    board[i][j] = 'o';
                } else if (board[i][j] == 'o') {
                    board[i][j] = 'x';
                }
            }

        }
    }

    class Pair {
        int head;
        int tail;
        Pair(int head, int tail) {
            this.head = head;
            this.tail = tail;
        }
    }
    private void fill(char[][] board, int row, int col, char r){
        Deque<Pair> stack = new ArrayDeque<Pair>();
        stack.offer(new Pair(row, col));
        while (stack.peek() != null) {
            Pair p = stack.pollFirst();
            row = p.head;
            col = p.tail;

            board[row][col] = r;
            if (row - 1 >= 0 && board[row - 1][col] == 'o') {
                stack.push(new Pair(row - 1, col));
            }
            if (row + 1 <= board.length - 1 && board[row + 1][col] == 'o') {
                stack.offer(new Pair(row + 1, col));
            }
            if (col - 1 >= 0 && board[row][col - 1] == 'o') {
                stack.offer(new Pair(row, col-1));
            }
            if (col + 1 <= board[0].length - 1 && board[row][col + 1] == 'o') {
                stack.offer(new Pair(row, col+1));
            }
        }
    }

    private char[][] toBoard(String[] s) {
        char[][] r = new char[s.length][];
        for (int i = 0; i < s.length; i++) {
            r[i] = s[i].toLowerCase().toCharArray();
        }
        return r;
    }

    public static void main(String[] args) {
        MarkRegion r = new MarkRegion();
        String[] b = {
                "XOXOXOOOXO",
                "XOOXXXOOOX",
                "OOOOOOOOXX",
                "OOOOOOXOOX",
                "OOXXOXXOOO",
                "XOOXXXOXXO",
                "XOXOOXXOXO",
                "XXOXXOXOOX",
                "OOOOXOXOXO",
                "XXOXXXXOOO"};

        char[][] board = r.toBoard(b);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }

        r.mark(board);
        System.out.println("========");

        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }

    }
}

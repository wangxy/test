package main.java.algorithms.src;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xwang on 4/11/16.
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> uniquesR = new HashSet<Character>();
            Set<Character> uniquesC = new HashSet<Character>();

            for (int j = 0; j < 9; j++) {
                System.out.println(uniquesR);
                System.out.println(uniquesC);
                if (!".".equals(String.valueOf(board[i][j]))) {
                    if (uniquesR.contains(board[i][j])) {
                        return false;
                    } else {
                        uniquesR.add(board[i][j]);
                    }
                }

                if (!".".equals(board[j][i])) {
                    if (uniquesC.contains(board[j][i])) {
                        return false;
                    } else {
                        uniquesC.add(board[j][i]);
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Set<Character> uniques = new HashSet<Character>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        int rowIdx = i * 3 + k;
                        int colIdx = j * 3 + l;
                        System.out.println(rowIdx + ", " + colIdx);
                        if (!".".equals(board[rowIdx][colIdx])) {
                            if (uniques.contains(board[rowIdx][colIdx])) {
                                return false;
                            } else {
                                uniques.add(board[rowIdx][colIdx]);
                            }
                        }
                    }
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] in = new char[][]{
                {'.', '8', '7', '6', '5', '4', '3', '2', '1'},
                {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'9', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        ValidSudoku v = new ValidSudoku();
        v.isValidSudoku(in);
    }

}


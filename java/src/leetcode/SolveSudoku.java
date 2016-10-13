package main.java.algorithms;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xwang on 9/16/16.
 */
public class SolveSudoku {
    private static class Position {
        byte x;
        byte y;
        Position(byte x, byte y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solve(char[][] board) {
    }

    private boolean solved(char[][] board) {
        return true;
    }
    private Position nextPos(char[][] board) {
        return null;
    }

    public static void main(String[] args) {
        Pattern p = Pattern.compile("508_.+");
        Matcher m = p.matcher("508_a");
        if (m.matches()) {
            System.out.println("found");
        } else {
            System.out.println("not found");
        }

    }

}

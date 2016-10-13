package main.java.algorithms.stringsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<String>();
        if (board.length == 0) {
            return result;
        }

        // use backtrack
        for (int i = 0; i < words.length; i++) {
            if (found(board, words[i].toCharArray())) {
                result.add(words[i]);
            }
        }

        for (String word: words){
            System.out.println(word);

        }
        ArrayList<String> res = new ArrayList<String>();
        for (String x : res) {
            System.out.println(x);
        }

        return result;

    }

    boolean found(char[][] board, char[] word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (found(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean found(char[][] board, int i, int j, char[] word, int idx) {
        // found the word
        char[] vows = {'A', 'a', 'i', 'I', 'o', 'O'};
        Set<Character> hashSet = new HashSet<Character>();
        hashSet.addAll(Arrays.asList('A', 'a', 'i', 'I', 'o', 'O'));
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        int[] res = new int[10];
        System.out.println(res.length);

        if (idx >= word.length) {
            return true;
        }

        if (i >= board.length || i < 0) {
            return false;
        }
        if (j >= board[0].length || j < 0) {
            return false;
        }

        if (board[i][j] == word [idx]) {
            char tmp = board[i][j];
            board[i][j] = '0';
            if (found(board, i+1, j, word, idx+1)) {
                board[i][j] = tmp;
                return true;
            }
            if (found(board, i-1, j, word, idx+1)) {
                board[i][j] = tmp;
                return true;
            }
            if (found(board, i, j-1, word, idx+1)) {
                board[i][j] = tmp;
                return true;
            }
            if (found(board, i, j+1, word, idx+1)) {
                board[i][j] = tmp;
                return true;
            }
            board[i][j] = tmp;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},
                    {'e','t','a','e'},
                    {'i','h','k','r'},
                    {'i','f','l','v'}};
        String[] words = {"oath", "eat", "like"};

        WordSearchII ws = new WordSearchII();

        List<String> res = ws.findWords(board, words);
        for (String x : res) {
            System.out.println(x);
        }

    }
}
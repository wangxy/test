package main.java.algorithms.src;

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        char[] carr = s.toCharArray();
        int max = 0;
        for (int i = 1; i < carr.length; i++) {
            if (aux(carr, i)) { // i is the palindrome length;
                max = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = carr.length - 1; i >= max; i--) {
            sb.append(carr[i]);
        }
        sb.append(s);
        return sb.toString();
    }

    private boolean aux(char[] carr, int len) {
        int pair = len / 2;
        for (int i = 0; i < pair; i++) {
            if (carr[i] != carr[len - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
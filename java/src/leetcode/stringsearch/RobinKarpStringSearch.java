package main.java.algorithms.stringsearch;

/**
 * Created by xwang on 5/2/16.
 */
public class RobinKarpStringSearch {
    int prim = 3;

    public int search(String str, String pattern) {
        char[] charArr = str.toCharArray();
        char[] ptnArr = pattern.toCharArray();

        int len = pattern.length();
        for (int i = 0; i < str.length() - len; i++) {
            //long hashval = computeHash(str.substring(i, i + len));
            System.out.println("Test");
        }
        return 0;
    }
 }

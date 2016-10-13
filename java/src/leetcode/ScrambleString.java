package main.java.algorithms;

import java.util.Arrays;

/**
 * 87. Scramble String  QuestionEditorial Solution  My Submissions
 Total Accepted: 53592
 Total Submissions: 193260
 Difficulty: Hard
 Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

 Below is one possible representation of s1 = "great":

 great
 /    \
 gr    eat
 / \    /  \
 g   r  e   at
           / \
          a   t
 To scramble the string, we may choose any non-leaf node and swap its two children.

 For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

 rgeat
 /    \
 rg    eat
 / \    /  \
 r   g  e   at
           / \
          a   t
 We say that "rgeat" is a scrambled string of "great".

 Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

 rgtae
 /    \
 rg    tae
 / \    /  \
 r   g  ta  e
       / \
      t   a

 great
 /   \
 g    reat
      /  \
      re  at
     / \  /\
     e  r t a

 We say that "rgtae" is a scrambled string of "great".

 Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
*/
 public class ScrambleString {
    // split the two strings at the same location, if both left and right contains the same set of characters. then
    // go deeper.


    public boolean isScramble(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        return aux(a, b);
    }

    private boolean aux(String a, String b) {
        if (a.length() == b.length() && a.length() == 1) {
            return a.equals(b);
        }

        for (int i = 1; i <= a.length() - 1; i++) {
            String aleft = a.substring(0, i);
            String aright = a.substring(i);
            String bleft = b.substring(0, i);
            String bright = b.substring(i);
            boolean leftMatch = false;
            if (match(aleft, bleft) && match(aright, bright)) {
                leftMatch = aux(aleft, bleft) && aux(aright, bright);
            }
            boolean rightMatch = false;
            bleft = b.substring(b.length() - i);
            bright = b.substring(0, b.length() - i);
            if (match(aleft, bleft) && match(aright, bright)) {
                rightMatch = aux(aleft, bleft) && aux(aright, bright);
            }
            if (leftMatch || rightMatch) {
                return true;
            }
        }
        return false;
    }

    private boolean match(String a, String b) {
        char[] ax = a.toCharArray();
        char[] bx = b.toCharArray();
        Arrays.sort(ax);
        Arrays.sort(bx);
        for (int i = 0; i < a.length(); i++) {
            if (ax[i] != bx[i]) {
                return false;
            }
        }
        return true;
    }

    // abb
    // bba
    public static void main(String[] args) {
        ScrambleString ss = new ScrambleString();
        System.out.println(ss.isScramble("abb", "bba"));


    }

}

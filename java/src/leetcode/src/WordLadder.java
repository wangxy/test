package main.java.algorithms.src;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xwang on 7/1/16.
 */
public class WordLadder {
    public int computeShortest(String startW, String endW, Set<String> words) {
        Queue<String> queue = new LinkedList<String>();
        queue.add(startW);
        int level = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.remove();
                if (cur.equals(endW)) {
                    return level + 1;
                }
                char[] r = cur.toCharArray();
                for (int j = 0; j < cur.length(); j++) {
                    char tmp = r[j];
                    for (char a = 'a'; a <= 'z'; a++) {
                        if (tmp == a) continue; // same
                        r[j] = a;
                        String newW = new String(r);
                        if (words.contains(newW)) queue.add(newW);
                    }
                    r[j] = tmp;
                }
            }
            level++;
        }
        return 0;
    }


    public static void main(String[] args) {
        Math.round(10/15);

    }
}

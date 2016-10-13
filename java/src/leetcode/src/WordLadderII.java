package main.java.algorithms.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 126. Word Ladder II   QuestionEditorial Solution  My Submissions
 Total Accepted: 53630
 Total Submissions: 391960
 Difficulty: Hard
 Contributors: Admin
 Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the word list
 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]
 Return
 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]
 Note:
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 */
public class WordLadderII {
    class GraphNode {
        String val;
        List<String> neighbors;

        GraphNode(String val) {
            this.val = val;
            this.neighbors = new ArrayList<String>();
        }

        public void addNeighbor(String w){
            this.neighbors.add(w);
        }
    }

    // thoughts: this can be considered a graph problem, with each of the adjacent words connected with distance 1
    public List<List<String>> wordLadderII(String start, String end, Set<String> words){
        String[] warr = (String[])words.toArray();
        Map<String, GraphNode>  map = new HashMap<String, GraphNode>();

        // created a graph
        for (int i = 0; i < warr.length - 1; i++) {
            for (int j = i + 1; j < warr.length; j++) {
                if (isNeighbor(warr[i], warr[j])) {
                    if (!map.containsKey(warr[i])) {
                        map.put(warr[i], new GraphNode(warr[i]));
                    }
                    map.get(warr[i]).addNeighbor(warr[j]);

                    if (!map.containsKey(warr[j])) {
                        map.put(warr[j], new GraphNode(warr[j]));
                    }
                    map.get(warr[j]).addNeighbor(warr[i]);
                }
            }
        }


    }

    private boolean isNeighbor(String s, String s1) {
        int diffCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s1.charAt(i)) {
                diffCnt++;
                if (diffCnt > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {


    }
}

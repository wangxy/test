import java.util.List;

/**
 * Created by xwang on 5/2/16.
 */
public class FindRepeatSequence {
    public List<String> findRepeated(String str) {
        char[] chars = str.toCharArray();

        TrieNode root = new TrieNode();
        for (int i = 0; i < chars.length - 10; i++) {
            for (int j = 0; j < 10; j++) {
            }

        }
        return null;

    }

}


class TrieNode {
    TrieNode[] children = new TrieNode[3];
    char val;
    boolean hasValue;
}
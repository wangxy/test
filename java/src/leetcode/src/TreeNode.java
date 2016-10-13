package main.java.algorithms.src;

/**
 * Created by xwang on 5/2/16.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode(int val) {
        this.val = val;
    }
}

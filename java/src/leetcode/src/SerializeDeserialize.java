package main.java.algorithms.src;

import java.util.Stack;

public class SerializeDeserialize {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // recursive approach
        if (root == null) {
            return "#";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {return null;}
        char[] carr = data.toCharArray();

        int curVal = 0;
        boolean isNull = false;
        boolean isRight = false;

        TreeNode cur = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        // basic idea, use stack to store the nodes
        // top of the stack is the one that has not been completed
        // since we are using pre-order to serialize the tree,
        // we read the root first, try to parse its left, then try to parse its right.

        for (int i = 0; i < carr.length; i++) {
            if (carr[i] == '#') {
                isNull = true;
            } else if (carr[i] == ',' || i == carr.length - 1) {
                // end of the input
                if (stack.empty()) { // first node
                    if (isNull) {
                        return null;
                    } else {
                        // push the node to the stack
                        stack.push(new TreeNode(curVal));
                        curVal = 0;
                        isRight = false;
                    }
                } else {
                    // not the first node.
                    if (isNull) {
                        if (!isRight) {
                            isRight = true;
                        } else {
                            // already doing the right, remove the first node.
                            cur = stack.pop();
                            while(!stack.empty() && stack.peek().right != null) {
                                cur = stack.pop();
                            }
                            isRight = false;
                        }
                    } else {
                        // no null
                        TreeNode n = new TreeNode(curVal);
                        curVal = 0;
                        if (!isRight) {
                            stack.peek().left = n;
                        } else {
                            stack.peek().right = n;
                        }
                        stack.push(n);
                        isRight = false;
                    }
                }
            } else {
                // start consume a value;
                curVal = curVal * 10 + (carr[i] - '0');
                isNull = false;
            }
        }
        while(!stack.empty()) {
            cur = stack.pop();
        }
        return cur;
    }

    public static void main(String[] args) {

        SerializeDeserialize sd = new SerializeDeserialize();

       // TreeNode n = new TreeNode(12, new TreeNode(1,  new TreeNode(2, null, null), null), null);
        TreeNode n = new TreeNode(1, null, new TreeNode(2, null, null));

        String s = sd.serialize(n);
        System.out.println(s);
        TreeNode nn = sd.deserialize(s);
        System.out.println(sd.serialize(nn));
    }

}

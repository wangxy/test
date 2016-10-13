package main.java.algorithms.src;

/**
 * Created by xwang on 4/28/16.
 */
public class MorrisTraversal {

    public void InOrderTraversal(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                // Left is null, visit current and start traverse right
                System.out.println(cur.val);
                cur = cur.right;
            } else {
                TreeNode pred = cur.left;
                while (pred.right != null && pred.right != cur) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    // establish the link
                    pred.right = cur;
                    cur = cur.left;
                } else {
                    // pred.right is not null, has already visited this node.
                    pred.right = null;
                    System.out.println(cur.val);
                    cur = cur.right;
                }
            }
        }
    }

    public void PreOrderTraversal(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                // no left child, visit current node and traverse right
                System.out.println("case 1: " + cur.val);

                cur = cur.right;
            } else {
                // has left child, need to visit left child.
                // find the preNode of current, so we know how to come back
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                   // System.out.println("add link: " + pre.val + " - " + cur.val);
                    pre.right = cur;
                    // visit cur;
                    System.out.println("case 2: " + cur.val);
                    cur = cur.left;
                } else {
                    // has visited this node
                   // System.out.println("break link: " + pre.val + " - " + cur.val);

                    pre.right = null;
                    cur = cur.right;

                }
            }
        }
    }

    public void flatten (TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                // Move cur.right to pre.right
                if (pre.right == null) {
                    pre.right = cur.right;
                    cur.right = null;
                }
                cur = cur.left;
            }
        }
        cur = root;
        while (cur.left != null || cur.right != null) {
            if (cur.left != null) {
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
        printTree(root);

    }

    public void printTree(TreeNode root) {
        if (root != null) {
            System.out.println(root.val + ((root.left == null ? ", null" : root.left.val) + ", " +
                    (root.right == null ? ",null" : root.right.val)));
            printTree(root.left);
            printTree(root.right);
        } else {
            System.out.println("null");
        }
    }


    public static void main(String[] args) {
        TreeNode node = new TreeNode(12,
                new TreeNode(10, new TreeNode(3, null, null), null),
                new TreeNode(30, null, null));
        MorrisTraversal trav = new MorrisTraversal();
        //trav.InOrderTraversal(node);
        //trav.PreOrderTraversal(node);
       trav.flatten(node);

        System.out.println((String.valueOf(new Integer(12))));

    }
}

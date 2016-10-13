package main.java.com.rocketfuel.sandbox.xwang;

import main.java.algorithms.src.ListNode;

/**
 * Created by xwang on 6/14/16.
 */
public class RevertList {

    public ListNode revert(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }

        ListNode pre = root;
        ListNode next = root.next;
        pre.next = null;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = pre;
            pre = next;
            next = tmp;
        }
        return pre;
    }

    private String printList(ListNode n) {
        if (n.next == null) {
            return String.valueOf(n.val);
        }
        return n.val + " -> " + printList(n.next);

    }
    public static void main(String[] args) {
        RevertList rl = new RevertList();
       // System.out.println(rl.revert(null));
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n1 = rl.revert(n1);
        System.out.println(rl.printList(n1));

    }
}

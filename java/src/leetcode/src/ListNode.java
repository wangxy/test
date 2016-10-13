package main.java.algorithms.src;

/**
 * Created by xwang on 6/14/16.
 */
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String toString() {
        if (this.next != null) {
            return this.val + "->" + this.next.toString();
        } else {
            return String.valueOf(this.val);
        }
    }

}

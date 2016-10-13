package main.java.algorithms.src;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class InsertionSort {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head;
        ListNode toAdd = head.next;
        newHead.next = null;

        while (toAdd != null) {
            ListNode next = toAdd.next;
            ListNode cur = newHead;
            ListNode pre = cur;
            while (cur != null && cur.val < toAdd.val) {
                pre = cur;
                cur = cur.next;
            }

            if (cur == null) {
                pre.next = toAdd;
                toAdd.next = null;  // move to new list;
            } else {
                if (cur == newHead) {
                    toAdd.next = newHead;
                    newHead = toAdd;
                } else {
                    pre.next = toAdd;
                    toAdd.next = cur;
                }
            }
            toAdd = next;
        }
        return newHead;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(30, new ListNode(20, new ListNode(40, null)));
        InsertionSort sort = new InsertionSort();
        ListNode result = sort.insertionSortList(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

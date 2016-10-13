package main.java.algorithms.src;

/**
 * Check whether a list is palindrome
 */
public class ListIsPalindrome {
    public boolean isPalin(ListNode head) {
        // 1. break the list into 2
        // 2. reverse the second list
        // 3. compare
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        ListNode tmp = slow.next;
        slow.next = null;
        tmp = revertList(tmp);
        ListNode p1 = head;
        ListNode p2 = tmp;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    private ListNode revertList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;
        p1.next = null;
        while (p2 != null) {
            ListNode tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListIsPalindrome ispal = new ListIsPalindrome();
        l = ispal.revertList(l);
        System.out.println(l.toString());

        l = new ListNode(1, new ListNode(2, null));
        l = ispal.revertList(l);
        System.out.println(l.toString());

        l = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        l = ispal.revertList(l);
        System.out.println(l.toString());

        System.out.println(ispal.isPalin(null));
        System.out.println(ispal.isPalin(new ListNode(1, null)));
        System.out.println(ispal.isPalin(new ListNode(1, new ListNode(2, null))));
        System.out.println(ispal.isPalin(new ListNode(1, new ListNode(2, new ListNode(1, null)))));
    }
}

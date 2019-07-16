package learn.list;

/**
 * 查找中间节点
 * https://leetcode.com/problems/middle-of-the-linked-list/solution/
 */
public class MiddleNode {
    public static ListNode findMiddleNode(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

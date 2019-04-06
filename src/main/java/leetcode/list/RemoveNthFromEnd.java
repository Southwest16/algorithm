package leetcode.list;

/**
 * 删除倒数第n个节点
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/solution/
 */
public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = head;
        int length = 0;
        //遍历得到链表的长度
        while (first != null) {
            length++;
            first = first.next;
        }

        length -= n;
        first = dummy;
        //移动first指针，走到要删除节点的前一个节点
        while (length > 0) {
            length--;
            first = first.next;
        }

        first.next = first.next.next;
        return dummy.next;
    }

    /** 使用两个指针 */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //dummy为辅助节点，用于链表只有一个节点或者删除链表head节点的情况
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;
        //移动fast指针，使slow和fast相隔n个节点
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }

        //同时移动slow和fast指针
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}

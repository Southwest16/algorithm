package leetcode.problems;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class _92_ReverseLinkedList2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reverseBetween(head, 2, 4);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        //先遍历到要反转节点的前一个节点
        for (int i = 0; i < left-1; i++) {
            prev = prev.next;
        }

        //开始节点
        ListNode currentNode = prev.next;
        //开始节点的下一个节点
        ListNode followNode = currentNode.next;

        // 1 -> 2 -> 3 -> 4 -> 5

        // 1 -> 2 -> 4 -> 4 -> 5
        // 1 -> 2 -> 4 -> 2 -> 5
        // 1 -> 3 -> 4 -> 2 -> 5
        // 1 -> 3 -> 2 -> 4 -> 5
        for (int i = 0; i < right-left; i++) {
            currentNode.next = followNode.next;
            followNode.next = prev.next;
            prev.next = followNode;
            followNode = currentNode.next;
        }

        return dummy.next;
    }
}

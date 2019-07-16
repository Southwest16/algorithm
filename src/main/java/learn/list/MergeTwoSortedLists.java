package learn.list;

/**
 * 合并两个有序的链表
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {
    public static ListNode mergeTwoSortedLists(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        if (head1.val < head2.val) {
            head1.next = mergeTwoSortedLists(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeTwoSortedLists(head1, head2.next);
            return head2;
        }
    }
}

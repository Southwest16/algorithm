package leetcode.problems;

import leetcode.ListNode;

/**
 * 求链表的中间结点
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class _876_MiddleOfLinkedList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);

		System.out.println(middleNode(head).val);

	}

	public static ListNode middleNode(ListNode head) {
		if (head.next == null) return head;

		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		if (fast.next == null)
			return slow;
		else
			return slow.next;
	}
}

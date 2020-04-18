package leetcode.linkedlist;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 * 检测链表中是否有环
 */
public class _141_LinkedListCycle {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = head;
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = head;

		System.out.println(hasCycle(head));

	}

	public static boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) return false;

		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != slow) {
			if (fast == null || fast.next == null) return false;

			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}

	//Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}

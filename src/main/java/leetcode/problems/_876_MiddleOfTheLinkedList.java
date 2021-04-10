package leetcode.problems;

/**
 * 查找链表的中间结点
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class _876_MiddleOfTheLinkedList {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;


		//查找中间节点
        System.out.println(_876_MiddleOfTheLinkedList.middleNode(n1).val);
	}

	public static ListNode middleNode(ListNode head) {
		if (head.next == null) return head;

		ListNode slow = head;
		ListNode fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}
}
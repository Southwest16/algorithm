package leetcode_hot100;

/**
 * 删除链表的倒数第N个节点
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * 使用双指针法
 *
 * 1. 指针first先走n+1步, 指针second先不动
 * 2. 指针first和second同时往前走(两指针之间保持相隔n个节点)
 * 3. 指针first走到null时, 指针second刚好在倒数第n个节点的前一个节点
 */
public class _19_RemoveNthNodeFromEndOfList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		removeNthFromEnd(head, 2);
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		// 哨兵节点
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode first = dummy;
		ListNode second = dummy;

		// first走n个节点
		for (int i = 0; i < n + 1; i++) {
			first = first.next;
		}

		// first和second之间保持n个节点的距离, 并一起往后遍历
		while (first != null) {
			first = first.next;
			second = second.next;
		}

		//删除倒数第N个节点
		second.next = second.next.next;
		return dummy.next;
	}
}

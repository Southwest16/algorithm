package leetcode.problems;

/**
 * 反转单链表
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class _206_ReverseLinkedList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ListNode tail = reverseList(head);

		while (tail != null) {
			System.out.println(tail.val);
			tail = tail.next;
		}

	}

	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;

		ListNode prev = null;
		ListNode currentNode = head;
		ListNode tmp = null;

		//1. 当前节点的下一个节点赋给临时变量
		//2. 当前节点的下一个节点置为当前节点的前一个节点
		//3. prev往前移动一位
		//4. currentNode往前移动一位
		while (currentNode != null) {
			tmp = currentNode.next;
			currentNode.next = prev;
			prev = currentNode;
			currentNode = tmp;
		}
		return prev;
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

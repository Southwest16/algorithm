package leetcode.problems;

import leetcode.ListNode;

/**
 * 移除链表中倒数第n个结点
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class _19_RemoveNthNodeFromEndOfList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
//		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(4);

		System.out.println(removeNthFromEnd(head, 1));

	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode tmp = new ListNode(-1);
		tmp.next = head;

		ListNode currNode = head;

		//获取链表长度
		int len = 0;
		while (currNode != null) {
			len++;
			currNode = currNode.next;
		}

		//复用这个变量
		currNode = tmp;

		//移动到要删除结点的前一个结点
		len = len - n;
		while (len > 0) {
			len--;
			currNode = currNode.next;
		}

		//删除指定结点
		currNode.next = currNode.next.next;
		return tmp.next;
	}



	/** 使用两个指针 */
	public static ListNode removeNthFromEnd2(ListNode head, int n) {
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

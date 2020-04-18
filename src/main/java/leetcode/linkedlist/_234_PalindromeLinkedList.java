package leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断单链表是否是回文
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class _234_PalindromeLinkedList {
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(1);
//		node.next.next = new ListNode(2);

		System.out.println(isPalindrome(node));
	}

	public static boolean isPalindrome(ListNode head) {
		//先将链表中元素全部拷贝到一个数组中
		List<Integer> list = new ArrayList<>();
		ListNode currentNode = head;
		while (currentNode != null){
			list.add(currentNode.val);
			currentNode = currentNode.next;
		}

		//初始化两个指针
		int first = 0;
		int second = list.size() - 1;

		//两指针分别从头部和尾部同时向中间遍历
		while (first < second) {
			if (list.get(first) != list.get(second)) {
				return false;
			}
			first++;
			second--;
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

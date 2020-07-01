package leetcode_hot100;

/**
 * 两数相加
 * https://leetcode.com/problems/add-two-numbers/
 */
public class _2_AddTwoNumbers {
	public static void main(String[] args) {
		ListNode h1 = new ListNode(2);
		h1.next = new ListNode(4);
		h1.next.next = new ListNode(8);

		ListNode h2 = new ListNode(5);
		h2.next = new ListNode(6);
		h2.next.next = new ListNode(4);

		System.out.println(addTwoNumbers(h1, h2));
	}


	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0); // 哨兵节点
		ListNode curr = dummyHead; // 结果链表
		int carry = 0; // 加法进位

		// 遍历链表
		while (l1 != null || l2 != null) {
			// 链表对应位置上的节点相加
			int sum = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);

			// 相加进位
			carry = sum / 10;

			// 当前位在相加并进位之后的数字
			curr.next = new ListNode(sum % 10);

			//结果链表往后移动一位
			curr = curr.next;

			// 两个链表当前节点往前移动一位
			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
		}

		// 两个链表最后两位相加是否要进位
		if (carry > 0) curr.next = new ListNode(carry);

		// 返回链表头节点
		return dummyHead.next;
	}
}

// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
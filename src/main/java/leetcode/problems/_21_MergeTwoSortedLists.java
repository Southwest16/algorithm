package leetcode.problems;

/**
 * 合并两个有序的链表
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class _21_MergeTwoSortedLists {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(3);
		l1.next.next = new ListNode(5);

		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(4);
		l2.next.next = new ListNode(6);

		ListNode result = mergeTwoLists(l1, l2);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}


	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		//对传入的参数判空
		if (l1 == null) return l2;
		if (l2 == null) return l1;

		//从头遍历两个链表, 哪个链表中结点的值较小, 就向前移动一步
		if (l1.val <= l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1; //返回较小值的头节点
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2; //返回较小值的头节点
		}
	}
}

package problems.list;

/**
 * 合并两个有序的链表
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		//如果其中一个链表为null, 直接返回另外一个链表
		if (l1 == null) return l2;
		if (l2 == null) return l1;

		//如果l1的值小于等于l2的值, 就取l1的next结点继续比较
		if (l1.val <= l2.val) {
			l1.next = mergeTwoLists(l1.next, l2); //递归调用
			return l1;
		} else {//如果l1的值大于l2的值, 就取l2的next结点继续比较
			l2.next = mergeTwoLists(l1, l2.next); //递归调用
			return l2;
		}
	}

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
}

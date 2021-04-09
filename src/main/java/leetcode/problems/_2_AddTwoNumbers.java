package leetcode.problems;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class _2_AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(addTwoNumbers(l1, l2).next.next.val);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int carry = 0; //进位

        //遍历两个链表
        while (node1 != null || node2 != null) {
            int v1 = (node1 != null) ? node1.val : 0; //链表1当前节点的值
            int v2 = (node2 != null) ? node2.val : 0; //链表2当前节点的值
            int sum = carry + v1 + v2;
            carry = sum / 10; //进位
            curr.next = new ListNode(sum % 10); //当前节点对应的值
            curr = curr.next;
            if(node1 != null) node1 = node1.next; //到下一个结点
            if(node2 != null) node2 = node2.next; //
        }

        //链表循环结束后, 检查是否要进位
        if(carry > 0)
            curr.next = new ListNode(carry);
        return head.next;
    }


    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}



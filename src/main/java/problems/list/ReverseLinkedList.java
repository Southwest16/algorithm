package problems.list;

/**
 * 反转一个单链表
 * https://leetcode.com/problems/reverse-linked-list
 */
public class ReverseLinkedList {

    public static ListNode reverseLinkedList(ListNode head) {
        if(head == null) return head;

        ListNode pre = null;
        ListNode curr = head;
        ListNode tmp = null;
        while (curr != null) {
            tmp = curr.next;    //将当前节点的next赋值给一个临时变量
            curr.next = pre;    //将当前节点的next反向指向pre
            pre = curr;         //pre向前走一步
            curr = tmp;         //curr向前走一步
        }
        return pre;
    }
}
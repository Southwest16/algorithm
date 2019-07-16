package learn.list;

public class Main {
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
        n5.next = n3;



        /*//合并两个有序的链表
        ListNode nn1 = new ListNode(6);
        ListNode nn2 = new ListNode(7);
        ListNode nn3 = new ListNode(8);
        ListNode nn4 = new ListNode(9);
        ListNode nn5 = new ListNode(10);

        nn1.next = nn2;
        nn2.next = nn3;
        nn3.next = nn4;
        nn4.next = nn5;
        nn5.next = null;

        System.out.println(MergeTwoSortedLists.mergeTwoSortedLists(n1, nn1).val);*/

        /*//移除倒数第n个节点
        System.out.println(RemoveNthFromEnd.removeNthFromEnd(n1, 5).val);*/


        /*//查找中间节点
        System.out.println(MiddleNode.findMiddleNode(n1).val);*/


        /*//检测链表是否有环
        System.out.println(CheckCycle.hasCycle(n1));
        System.out.println(CheckCycle.hasCycle2(n1));*/


        /*//反转一个单链表
        ListNode pre = ReverseLinkedList.reverseLinkedList(n1);
        System.out.println(
            pre.val +"\n"+
                pre.next.val +"\n"+
                pre.next.next.val +"\n"+
                pre.next.next.next.val +"\n"+
                pre.next.next.next.next);*/
    }
}

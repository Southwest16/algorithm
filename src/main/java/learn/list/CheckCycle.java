package learn.list;

import java.util.HashSet;
import java.util.Set;

/**
 * 检测链表中是否有环
 */
public class CheckCycle {

    //用两个指针，慢指针每次走一步，快指针每次走两步，判断快慢指针是否相遇
    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;

            slow = slow.next;       //慢指针每次走一步
            fast = fast.next.next;  //快指针每次走两步
        }
        return true;
    }

    //用一个HashSet保存访问过的数据
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (seen.contains(head)) {
                return true;
            } else {
                seen.add(head);
            }
            head = head.next;
        }
        return false;
    }
}

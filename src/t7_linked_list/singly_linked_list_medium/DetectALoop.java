package t7_linked_list.singly_linked_list_medium;

import java.util.HashSet;
import java.util.Set;

public class DetectALoop {
    public boolean method1(ListNode head) {
        Set<ListNode> se = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            if (se.contains(temp))
                return true;
            se.add(temp);
            temp = temp.next;
        }
        return false;
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
}

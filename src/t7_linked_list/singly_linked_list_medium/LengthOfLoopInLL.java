package t7_linked_list.singly_linked_list_medium;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLoopInLL {
    public int findLengthOfLoop(ListNode head) {
        int count = 1;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                //cycle found
                slow = slow.next;
                while (slow != fast) {
                    slow = slow.next;
                    count++;
                }
                return count;
            }
        }
        return 0;
    }

    public int method1(ListNode head) {
        int timer = 0;
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode temp = head;
        while (temp != null) {
            if (map.containsKey(temp)) {
                return timer - map.get(temp);
            }
            map.put(temp, timer++);
            temp = temp.next;
        }
        return 0;
    }
}

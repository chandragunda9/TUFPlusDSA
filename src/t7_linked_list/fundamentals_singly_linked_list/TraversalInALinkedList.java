package t7_linked_list.fundamentals_singly_linked_list;

import java.util.ArrayList;
import java.util.List;

public class TraversalInALinkedList {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public List<Integer> LLTraversal(ListNode head) {
        List<Integer> ans = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            ans.add(temp.val);
            temp = temp.next;
        }
        return ans;
    }
}

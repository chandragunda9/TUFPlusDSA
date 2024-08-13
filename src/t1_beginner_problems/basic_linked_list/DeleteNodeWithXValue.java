package t1_beginner_problems.basic_linked_list;

public class DeleteNodeWithXValue {
    public ListNode deleteNodeWithValueX(ListNode head, int X) {
        if (head.val == X)
            return head.next;
        ListNode current = head, prev = null;
        while (current != null) {
            if (current.val == X) {
                prev.next = current.next;
                break;
            }
            prev = current;
            current = current.next;
        }
        return head;
    }
}

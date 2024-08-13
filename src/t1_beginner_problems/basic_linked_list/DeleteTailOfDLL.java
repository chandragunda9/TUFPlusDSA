package t1_beginner_problems.basic_linked_list;

public class DeleteTailOfDLL {
    public ListNode deleteTail(ListNode head) {
        if (head.next == null)
            return null;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
        return head;
    }
}

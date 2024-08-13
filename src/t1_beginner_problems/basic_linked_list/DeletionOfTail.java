package t1_beginner_problems.basic_linked_list;

public class DeletionOfTail {
    public ListNode deleteTail(ListNode head) {
        if (head.next == null)
            return null;
        ListNode temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
}

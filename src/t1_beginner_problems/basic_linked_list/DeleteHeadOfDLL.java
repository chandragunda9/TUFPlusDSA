package t1_beginner_problems.basic_linked_list;

public class DeleteHeadOfDLL {
    public ListNode deleteHead(ListNode head) {
        if (head.next != null) {
            head.next.prev = null;
        }
        return head.next;
    }
}

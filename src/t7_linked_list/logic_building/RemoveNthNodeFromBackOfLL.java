package t7_linked_list.logic_building;

public class RemoveNthNodeFromBackOfLL {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        ListNode slow = head, fast = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        if (fast == null)
            return head.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}

package t1_beginner_problems.basic_linked_list;

public class InsertionAtTail {
    public ListNode insertAtTail(ListNode head, int X) {
        ListNode node = new ListNode(X);
        if (head == null) {
            return node;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        return head;
    }
}

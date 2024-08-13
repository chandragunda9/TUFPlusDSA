package t1_beginner_problems.basic_linked_list;

public class InsertionAtHead {
    public ListNode insertAtHead(ListNode head, int X) {
        ListNode node = new ListNode(X);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        return head;
    }
}

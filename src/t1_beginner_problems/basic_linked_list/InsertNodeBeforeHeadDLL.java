package t1_beginner_problems.basic_linked_list;

public class InsertNodeBeforeHeadDLL {
    public ListNode insertBeforeHead(ListNode head, int X) {
        ListNode node = new ListNode(X);
        if (head != null) {
            node.next = head;
            head.prev = node;
        }
        head = node;
        return head;
    }
}

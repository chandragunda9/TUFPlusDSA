package t1_beginner_problems.basic_linked_list;

public class InsertBeforeValueX {
    public ListNode insertBeforeX(ListNode head, int X, int val) {
        ListNode node = new ListNode(val);
        if (head.val == X) {
            node.next = head;
            return node;
        }
        ListNode temp = head, prev = null;
        while (temp != null && temp.val != X) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null)
            return head;
        prev.next = node;
        node.next = temp;
        return head;
    }
}

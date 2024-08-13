package t1_beginner_problems.basic_linked_list;

public class InsertionAtKthPos {
    public ListNode insertAtKthPosition(ListNode head, int X, int K) {
        ListNode node = new ListNode(X);
        if (K == 1) {
            node.next = head;
            return node;
        }
        ListNode temp = head;
        int ind = 1;
        while (ind < K - 1) {
            temp = temp.next;
            ind++;
        }
        node.next = temp.next;
        temp.next = node;
        return head;
    }
}

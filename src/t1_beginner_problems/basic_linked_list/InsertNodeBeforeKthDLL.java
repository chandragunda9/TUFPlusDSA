package t1_beginner_problems.basic_linked_list;

public class InsertNodeBeforeKthDLL {
    public ListNode insertBeforeKthPosition(ListNode head, int X, int K) {
        ListNode node = new ListNode(X);
        if (K == 1) {
            node.next = head;
            head.prev = node;
            return node;
        }
        ListNode temp = head;
        int pos = 1;
        while (pos < K) {
            temp = temp.next;
            pos++;
        }
        temp.prev.next = node;
        node.prev = temp.prev;
        node.next = temp;
        temp.prev = node;
        return head;
    }
}

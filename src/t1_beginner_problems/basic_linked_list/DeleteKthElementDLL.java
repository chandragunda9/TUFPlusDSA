package t1_beginner_problems.basic_linked_list;

public class DeleteKthElementDLL {
    public ListNode deleteKthElement(ListNode head, int k) {
        if (k == 1) {
            if (head.next != null) {
                head.next.prev = null;
            }
            return head.next;
        }
        ListNode temp = head;
        int ind = 1;
        while (temp != null && ind < k) {
            temp = temp.next;
            ind++;
        }
        if (temp != null) {
            temp.prev.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
        }
        return head;
    }
}

package t7_linked_list.hard;

public class RotateALL {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;
        ListNode temp = head;
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            ++length;
        }
        k = k % length;
        if (k == 0)
            return head;
        k = k - length;
        temp.next = head;
        while (k-- > 0) {
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }
}

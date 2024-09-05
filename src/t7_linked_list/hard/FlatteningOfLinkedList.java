package t7_linked_list.hard;

public class FlatteningOfLinkedList {
    public ListNode flattenLinkedList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode l2 = flattenLinkedList(head.next);
        return mergeTwoLinkedLists(head, l2);
    }

    public ListNode mergeTwoLinkedLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.child = l1;
                l1 = l1.child;
            } else {
                temp.child = l2;
                l2 = l2.child;
            }
            temp = temp.child;
            temp.next = null;
        }
        if (l1 != null) {
            temp.child = l1;
        } else {
            temp.child = l2;
        }
        return dummy.child;
    }

    public static void main(String[] args) {
        int n = 6, count = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j += i) {
                count++;
            }
        }
        System.out.println(count);
    }
}

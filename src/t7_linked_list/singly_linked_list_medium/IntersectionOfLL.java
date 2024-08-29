package t7_linked_list.singly_linked_list_medium;

public class IntersectionOfLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode p1 = headA, p2 = headB;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1 == null) {
            p1 = headB;
            while (p2 != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            p2 = headA;
        } else {
            p2 = headA;
            while (p1 != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            p1 = headB;
        }

        while (p1 != null && p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        ListNode head2 = new ListNode(7);
        head2.next = new ListNode(8);
        head2.next.next = head1.next.next.next;

        IntersectionOfLL obj = new IntersectionOfLL();
        System.out.println(obj.getIntersectionNode(head1, head2));
    }
}

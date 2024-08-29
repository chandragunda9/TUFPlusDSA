package t7_linked_list.logic_building;

public class Sort0s1s2s {
    public ListNode method1(ListNode head) {
        int c0 = 0, c1 = 0, c2 = 0;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val == 0) {
                c0++;
            } else if (temp.val == 1) {
                c1++;
            } else {
                c2++;
            }
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            if (c0 > 0) {
                temp.val = 0;
                c0--;
            } else if (c1 > 0) {
                temp.val = 1;
                c1--;
            } else {
                temp.val = 2;
                c2--;
            }
            temp = temp.next;
        }
        return head;
    }

    public ListNode sortList(ListNode head) {
        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);

        ListNode d0 = zeroHead;
        ListNode d1 = oneHead;
        ListNode d2 = twoHead;

        ListNode temp = head;
        while (temp != null) {
            if (temp.val == 0) {
                d0.next = temp;
                d0 = temp;
            } else if (temp.val == 1) {
                d1.next = temp;
                d1 = temp;
            } else {
                d2.next = temp;
                d2 = temp;
            }
            temp = temp.next;
        }

        //connecting all lists
        d0.next = (oneHead.next == null) ? twoHead.next : oneHead.next;
        d1.next = twoHead.next;
        d2.next = null;
        return zeroHead.next;
    }
}

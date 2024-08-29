package t7_linked_list.logic_building;

import java.util.ArrayList;
import java.util.List;

public class SegregateOddAndEvenNodes {
    public ListNode method1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        List<Integer> nodes = new ArrayList<>();
        //Odd nodes
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            nodes.add(temp.val);
            temp = temp.next.next;
        }
        if (temp != null) {
            nodes.add(temp.val);
        }
        //Even nodes
        temp = head.next;
        while (temp != null && temp.next != null) {
            nodes.add(temp.val);
            temp = temp.next.next;
        }
        if (temp != null) {
            nodes.add(temp.val);
        }

        temp = head;
        int ind = 0;
        while (temp != null) {
            temp.val = nodes.get(ind);
            temp = temp.next;
            ind++;
        }
        return head;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode odd = head, even = head.next, evenHead = head.next;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

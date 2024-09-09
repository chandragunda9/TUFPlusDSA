package GFGProblems.linkedlist;

public class SortLL {
    static Node segregate(Node head) {
        Node zeroHead = new Node(-1), d0 = zeroHead;
        Node oneHead = new Node(-1), d1 = oneHead;
        Node twoHead = new Node(-1), d2 = twoHead;
        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                d0.next = temp;
                d0 = d0.next;
            } else if (temp.data == 1) {
                d1.next = temp;
                d1 = d1.next;
            } else {
                d2.next = temp;
                d2 = d2.next;
            }
            temp = temp.next;
        }

        d1.next = twoHead.next;
        d0.next = oneHead.next;
        d2.next = null;
        return zeroHead.next;
    }
}

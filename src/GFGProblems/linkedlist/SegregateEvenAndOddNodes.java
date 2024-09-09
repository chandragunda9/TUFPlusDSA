package GFGProblems.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class SegregateEvenAndOddNodes {
    Node method1(Node head) {
        return null;
    }

    Node divide(Node head) {
        Node dumOdd = new Node(-1), dumEven = new Node(-1);
        Node temp1 = dumEven, temp2 = dumOdd;
        Node temp = head;
        while (temp != null) {
            if ((temp.data & 1) == 0) {
                temp1.next = temp;
                temp1 = temp1.next;
            } else {
                temp2.next = temp;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        temp2.next = null;
        if (dumEven.next == null) {
            return dumOdd.next;
        }
        temp1.next = dumOdd.next;
        return dumEven.next;
    }

    void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SegregateEvenAndOddNodes obj = new SegregateEvenAndOddNodes();
//        17->15->8->9->2->4->6
        Node head = new Node(17);
        head.next = new Node(15);
        head.next.next = new Node(8);
        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(6);

        Node ans = obj.divide(head);
        obj.print(ans);
    }
}

package t7_linked_list.logic_building;

public class AddTwoNumbersGFG {
    static Node addTwoLists(Node l1, Node l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        int carry = 0;
        Node dummy = new Node(-1), temp = dummy;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;
            temp.next = new Node(sum % 10);
            temp = temp.next;
        }
        return reverse(dummy.next);
    }

    static Node reverse(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

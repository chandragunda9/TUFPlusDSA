package t7_linked_list.singly_linked_list_medium;

public class AddOneToLL {
    public ListNode method1(ListNode head) {
        ListNode revHead = reverse(head);
        ListNode dummy = new ListNode(-1), temp = dummy;
        int carry = 1;
        while (revHead != null || carry != 0) {
            int sum = 0;
            if (revHead != null) {
                sum += revHead.val;
                revHead = revHead.next;
            }
            sum += carry;
            carry = sum / 10;
            int digit = sum % 10;
            temp.next = new ListNode(digit);
            temp = temp.next;
        }
        return reverse(dummy.next);
    }

    ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null;
        while (curr != null) {
            ListNode forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        AddOneToLL obj = new AddOneToLL();
        ListNode h = obj.addOne(head);
        while (h != null) {
            System.out.print(h.val + " ");
            h = h.next;
        }
    }

    public ListNode addOne(ListNode head) {
        if (head == null)
            return null;
        int carry = getCarry(head);
        if (carry == 1) {
            ListNode node = new ListNode(1);
            node.next = head;
            head = node;
        }
        return head;
    }

    int getCarry(ListNode head) {
        if (head == null)
            return 1;
        int carry = getCarry(head.next);
        head.val += carry;
        if (head.val < 10)
            return 0;
        head.val = 0;
        return 1;
    }
}

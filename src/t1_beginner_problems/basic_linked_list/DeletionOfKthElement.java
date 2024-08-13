package t1_beginner_problems.basic_linked_list;

public class DeletionOfKthElement {
    public ListNode deleteKthNode(ListNode head, int k) {
        if (k == 1) {
            return head.next;
        }
        int ind = 1;
        ListNode temp = head;
        while (ind < k - 1 && temp != null) {
            temp = temp.next;
            ind++;
        }

        //Kth node is not there
        if (temp == null || temp.next == null) {
            return head;
        }
        //temp.next is basically the Kth node
        temp.next = temp.next.next;
        return head;
    }
}

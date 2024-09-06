package t7_linked_list.faqs_dll;

public class RemovedDuplicatesFromSortedDLL {
    public ListNode removeDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            ListNode nextNode = temp.next;
            while (nextNode != null && nextNode.val == temp.val) {
                nextNode = nextNode.next;
            }
            temp.next = nextNode;
            if (nextNode != null) {
                nextNode.prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }
}

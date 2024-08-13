package t1_beginner_problems.basic_linked_list;

public class RemoveGivenNodeInDLL {
    public void deleteGivenNode(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;
        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }
    }
}

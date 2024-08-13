package t1_beginner_problems.basic_linked_list;

public class InsertNodeBeforeGivenNode {
    public void insertBeforeGivenNode(ListNode node, int X) {
        ListNode newNode = new ListNode(X);
        node.prev.next = newNode;
        newNode.prev = node.prev;
        newNode.next = node;
        node.prev = newNode;
    }
}

package t1_beginner_problems.basic_linked_list;

public class InsertNodeBeforeTailDLL {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        int x = 6;
        head = insertBeforeTail(head, x);
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static ListNode insertBeforeTail(ListNode head, int X) {
        ListNode node = new ListNode(X);
        if (head.next == null) {
            node.next = head;
            head.prev = node;
            return node;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = node;
        node.prev = temp.prev;
        node.next = temp;
        temp.prev = node;
        return head;
    }
}

package t7_linked_list.singly_linked_list_medium;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
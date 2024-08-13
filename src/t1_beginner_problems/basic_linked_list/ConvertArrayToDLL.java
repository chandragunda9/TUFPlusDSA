package t1_beginner_problems.basic_linked_list;

public class ConvertArrayToDLL {
    public ListNode arrayToLinkedList(int[] nums) {
        if (nums.length == 0)
            return null;
        ListNode head = new ListNode(nums[0]), prev = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode curr = new ListNode(nums[i]);
            prev.next = curr;
            curr.prev = prev;
            prev = curr;
        }
        return head;
    }
}

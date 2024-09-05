package t7_linked_list.hard;

public class ReverseLLInGroupsOfSizeK {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head, prevLLNode = null, nextLLNode = null, newHead = null;
        while (temp != null) {
            ListNode kthNode = findKthNode(temp, k);
            if (kthNode == null) {
                if (prevLLNode != null) {
                    prevLLNode.next = temp;
                }
                break;
            }
            nextLLNode = kthNode.next;
            kthNode.next = null;
            reverse(temp);
            if (temp == head) {
                newHead = kthNode;
            } else {
                prevLLNode.next = kthNode;
            }
            prevLLNode = temp;
            temp = nextLLNode;
        }
        return newHead;
    }

    static ListNode reverse(ListNode curr) {
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private ListNode findKthNode(ListNode temp, int k) {
        int count = 1;
        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }
        return temp;
    }
}

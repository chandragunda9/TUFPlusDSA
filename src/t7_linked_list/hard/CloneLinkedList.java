package t7_linked_list.hard;

import java.util.HashMap;
import java.util.Map;

public class CloneLinkedList {
    public ListNode method1(ListNode head) {
        if (head == null)
            return null;
        Map<ListNode, ListNode> map = new HashMap<>();
        ListNode temp = head;
        while (temp != null) {
            ListNode node = new ListNode(temp.val);
            map.put(temp, node);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            ListNode copyNode = map.get(temp);
            if (temp.next != null)
                copyNode.next = map.get(temp.next);
            if (temp.random != null)
                copyNode.random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }

    public ListNode copyRandomList(ListNode head) {
        if (head == null)
            return null;
        //step1 :create nodes and place in between in original nodes
        ListNode temp = head;
        while (temp != null) {
            ListNode copyNode = new ListNode(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }
        //step2 : connect random pointers
        temp = head;
        while (temp != null) {
            ListNode copyNode = temp.next;
            if (temp.random != null)
                copyNode.random = temp.random.next;
            temp = temp.next.next;
        }
        //step3:  connect next pointers
        temp = head;
        ListNode dummy = new ListNode(-1), res = dummy;
        while (temp != null) {
            //new list
            res.next = temp.next;
            res = res.next;
            //reverting original list back
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}

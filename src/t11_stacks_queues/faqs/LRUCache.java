package t11_stacks_queues.faqs;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key, value;
    Node prev, next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    Node head, tail;
    Map<Integer, Node> map;
    int cap;

    public LRUCache(int cap) {
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.cap = cap;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node del = map.get(key);
        deleteNode(del);
        insertAfterHead(del);
        return del.value;
    }

    void insertAfterHead(Node node) {
        Node nextNode = head.next;
        node.next = nextNode;
        node.prev = head;
        head.next = node;
        nextNode.prev = node;
    }

    void deleteNode(Node node) {
        Node nextNode = node.next;
        Node prevNode = node.prev;

        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;

            deleteNode(node);
            insertAfterHead(node);
            return;
        }

        if (map.size() == cap) {
            Node leastRecentlyUsed = tail.prev;
            deleteNode(leastRecentlyUsed);
            map.remove(leastRecentlyUsed.key);
        }

        Node node = new Node(key, value);
        insertAfterHead(node);
        map.put(key, node);
    }
}
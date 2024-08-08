package t1_beginner_problems.basic_stacks;

class LinkedListQueue {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public LinkedListQueue() {
        this.head = null;
    }

    public void push(int x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int pop() {
        if (head != null) {
            int data = head.data;
            head = head.next;
            return data;
        }
        return -1;
    }

    public int peek() {
        if (head != null) {
            return head.data;
        }
        return -1;
    }

    public boolean isEmpty() {
        return head == null;
    }
}

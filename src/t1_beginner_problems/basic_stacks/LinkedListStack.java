package t1_beginner_problems.basic_stacks;

public class LinkedListStack {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node startNode;

    public LinkedListStack() {
        this.startNode = null;
    }

    //if startNode is not null, then insert the node and pointing to the startNode
    //if startNode is null, it's the first node so point newNode to startNode
    public void push(int x) {
        Node newNode = new Node(x);
        if (!isEmpty()) {
            newNode.next = startNode;
        }
        startNode = newNode;
    }

    //if startNode is not null, then only popping the top element
    public int pop() {
        if (!isEmpty()) {
            int data = startNode.data;
            startNode = startNode.next;
            return data;
        }
        return -1;
    }

    //if startNode is not null, then only returning the top element
    public int top() {
        if (!isEmpty()) {
            return startNode.data;
        }
        return -1;
    }

    //check if startNode is null, if null then stack is empty
    public boolean isEmpty() {
        return startNode == null;
    }
}

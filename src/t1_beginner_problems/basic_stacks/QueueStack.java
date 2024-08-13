package t1_beginner_problems.basic_stacks;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStack {
    Queue<Integer> q;

    public QueueStack() {
        this.q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
        int size = q.size();
        for (int i = 1; i < size; i++) {
            q.add(q.poll());
        }
    }

    public int pop() {
        if (!isEmpty()) {
            return q.poll();
        }
        return -1;
    }

    public int top() {
        if (!isEmpty()) {
            return q.peek();
        }
        return -1;
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {
        QueueStack st = new QueueStack();
        st.push(4);
        st.push(8);
        System.out.println(st.pop());
        System.out.println(st.top());
        System.out.println(st.isEmpty());
    }
}

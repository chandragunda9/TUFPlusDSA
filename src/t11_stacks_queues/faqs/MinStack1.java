package t11_stacks_queues.faqs;

import java.util.Stack;

class MinStack1 {
    Stack<int[]> st;

    public MinStack1() {
        st = new Stack<>();
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push(new int[]{val, val});
        } else {
            st.push(new int[]{val, Math.min(val, st.peek()[1])});
        }
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek()[0];
    }

    public int getMin() {
        return st.peek()[1];
    }
}
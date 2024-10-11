package t11_stacks_queues.faqs;

import java.util.Stack;

class MinStack {
    Stack<Integer> st;
    int mini = Integer.MAX_VALUE;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push(val);
            mini = val;
        } else {
            if (val > mini) {
                st.push(val);
            } else {
                int newVal = 2 * val - mini;
                st.push(newVal);
                mini = val;
            }
        }
    }

    public void pop() {
        if (st.isEmpty())
            return;
        int top = st.peek();
        st.pop();
        if (top < mini) {
            // so it's a modified value
            //because val is less than mini?
            mini = 2 * mini - top;
        }
    }

    public int top() {
        if (st.isEmpty())
            return -1;
        int top = st.peek();
        return Math.max(top, mini);
    }

    public int getMin() {
        return mini;
    }
}
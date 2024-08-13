package t1_beginner_problems.basic_stacks;

import java.util.Stack;

class StackQueue {
    Stack<Integer> st1, st2;

    public StackQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int x) {
        st1.push(x);
    }

    public int pop() {
        if (isEmpty())
            return -1;
        if (st2.isEmpty()) {
            //all elements s1->s2
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        return st2.pop();
    }

    public int peek() {
        if (isEmpty())
            return -1;
        if (st2.isEmpty()) {
            //all elements s1->s2
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }
        return st2.peek();
    }

    public boolean isEmpty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}
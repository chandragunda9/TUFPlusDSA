package t1_beginner_problems.basic_stacks;

public class ArrayStack {
    int[] stack;
    int top, size;

    public ArrayStack() {
        this.size = 100;
        this.stack = new int[size];
        this.top = -1;
    }

    public void push(int x) {
        if (top >= size - 1)
            return;
        stack[++top] = x;
    }

    public int pop() {
        if (isEmpty())
            return -1;
        return stack[top--];
    }

    public int top() {
        if (isEmpty())
            return -1;
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

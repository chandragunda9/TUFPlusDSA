package t1_beginner_problems.basic_stacks;

public class ArrayQueue {
    int[] queueArray;
    int size;
    int frontInd, rearInd;

    public ArrayQueue() {
        this.size = 100;
        this.queueArray = new int[size];
        this.frontInd = -1;
        this.rearInd = -1;
    }

    public void push(int x) {
        if (rearInd >= size - 1) {
            return;
        }
        queueArray[++rearInd] = x;
    }

    public int pop() {
        if (!isEmpty()) {
            return queueArray[++frontInd];
        }
        return -1;
    }

    public int peek() {
        if (!isEmpty()) {
            return queueArray[frontInd + 1];
        }
        return -1;
    }

    public boolean isEmpty() {
        return rearInd == frontInd;
    }
}


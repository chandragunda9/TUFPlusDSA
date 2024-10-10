package t11_stacks_queues.monotonic_stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public int[] nextLargerElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] >= st.peek()) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
        return ans;
    }

    public int[] method1(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 1; i < arr.length; i++) {
            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                ans[st.peek()] = arr[i];
                st.pop();
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int i = st.pop();
            ans[i] = -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 3};
        NextGreaterElement obj = new NextGreaterElement();
        System.out.println(Arrays.toString(obj.method1(arr)));
    }
}

package t11_stacks_queues.monotonic_stack;

import java.util.Stack;

public class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length, sum = 0, mod = (int) (1e9 + 7);
        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);
        for (int i = 0; i < n; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;
            long mul = ((long) left * arr[i] * right) % mod;
            sum = (sum + (int) mul) % mod;
        }
        return sum;
    }

    int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    //find previous smaller or equal element
    int[] findPSEE(int[] arr) {
        int n = arr.length;
        int[] psee = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return psee;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5};
        SumOfSubarrayMinimums obj = new SumOfSubarrayMinimums();
        System.out.println(obj.sumSubarrayMins(arr));
    }
}

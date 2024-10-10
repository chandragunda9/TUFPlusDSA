package t11_stacks_queues.monotonic_stack;

import java.util.Stack;

public class SumOfSubarrayRanges {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }

    public long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long sum = 0;
        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);
        for (int i = 0; i < n; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;
            long mul = (long) left * arr[i] * right;
            sum += mul;
        }
        return sum;
    }

    public long sumSubarrayMaxs(int[] arr) {
        int n = arr.length;
        long sum = 0;
        int[] nge = findNGE(arr);
        int[] pgee = findPGEE(arr);
        for (int i = 0; i < n; i++) {
            int left = i - pgee[i];
            int right = nge[i] - i;
            long mul = (long) left * arr[i] * right;
            sum += mul;
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

    int[] findNGE(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nge;
    }

    //find previous smaller or equal element
    int[] findPGEE(int[] arr) {
        int n = arr.length;
        int[] pgee = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            pgee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pgee;
    }

    public static void main(String[] args) {
        int[] arr = {4, -2, -3, 4, 1};
        SumOfSubarrayRanges obj = new SumOfSubarrayRanges();
        System.out.println(obj.subArrayRanges(arr));
    }
}

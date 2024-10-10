package t11_stacks_queues.monotonic_stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];

        for (int i = 2 * n - 1; i >= 0; i--) {
            int calculatedIndex = i % n;
            while (!st.isEmpty() && arr[calculatedIndex] >= st.peek()) {
                st.pop();
            }
            if (i < n) {
                ans[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(arr[calculatedIndex]);
        }
        return ans;
    }

    //below code not that efficient
    public int[] method1(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < 2 * n; i++) {
            int ind = i % n;
            while (!st.isEmpty() && arr[ind] > arr[st.peek()]) {
                ans[st.peek()] = arr[ind];
                st.pop();
            }
            st.push(ind);
        }
        return ans;
    }

    public int[] method2(int[] arr) {
        //checking for every element, next all other elements
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= i + n - 1; j++) {
                int ind = j % n;
                if (arr[ind] > arr[i]) {
                    ans[i] = arr[ind];
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] arr = {3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9};
        int[] arr = {5, 7, 1, 7, 6, 0};
        NextGreaterElementII obj = new NextGreaterElementII();
        System.out.println(Arrays.toString(obj.method2(arr)));
        System.out.println(Arrays.toString(obj.method1(arr)));
        System.out.println(Arrays.toString(obj.nextGreaterElements(arr)));
    }
}

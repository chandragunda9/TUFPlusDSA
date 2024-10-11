package t11_stacks_queues.faqs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StockSpanProblem {
    int[] findPGE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    public int[] stockSpan(int[] arr, int n) {
        int[] pge = findPGE(arr);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = i - pge[i];
        }
        return ans;
    }

    public int[] method1(int[] arr, int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] <= arr[i])
                    count++;
                else
                    break;
            }
            ans.add(count);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {15, 13, 12, 14, 16, 20};
        StockSpanProblem obj = new StockSpanProblem();
        System.out.println(Arrays.toString(obj.method1(arr, arr.length)));
        System.out.println(Arrays.toString(obj.stockSpan(arr, arr.length)));
    }
}

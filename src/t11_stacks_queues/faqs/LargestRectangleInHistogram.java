package t11_stacks_queues.faqs;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        //use of the concept of pse
        int n = heights.length;
        Stack<Integer> pseStack = new Stack<>();
        int largest = 0;
        for (int i = 0; i < n; i++) {
            while (!pseStack.isEmpty() && heights[pseStack.peek()] >= heights[i]) {
                int poppedEleInd = pseStack.pop();
                int nextSmallerEleInd = i;
                int prevSmallerEleInd = pseStack.isEmpty() ? -1 : pseStack.peek();
                largest = Math.max(largest,
                        heights[poppedEleInd] * (nextSmallerEleInd - prevSmallerEleInd - 1));
            }
            pseStack.push(i);
        }

        while (!pseStack.isEmpty()) {
            int popInd = pseStack.pop();
            int nextSmallerEleInd = n;
            int prevSmallerEleInd = pseStack.isEmpty() ? -1 : pseStack.peek();
            largest = Math.max(largest,
                    heights[popInd] * (nextSmallerEleInd - prevSmallerEleInd - 1));
        }
        return largest;
    }

    public int method1(int[] heights) {
        int n = heights.length;
        int[] nse = findNSE(heights);
        int[] pse = findPSE(heights);
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, (nse[i] - pse[i] - 1) * heights[i]);
        }
        return max;
    }

    int[] findNSE(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] nse = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = (st.isEmpty()) ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    int[] findPSE(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] pse = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            pse[i] = (st.isEmpty()) ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 7, 5, 9};
        LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
        System.out.println(Arrays.toString(obj.findNSE(arr)));
        System.out.println(Arrays.toString(obj.findPSE(arr)));
        System.out.println(obj.method1(arr));
        System.out.println(obj.largestRectangleArea(arr));
    }
}

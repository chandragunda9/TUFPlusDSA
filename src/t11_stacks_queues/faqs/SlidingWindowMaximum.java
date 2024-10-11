package t11_stacks_queues.faqs;

import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] arr, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            //if first index is less than current window starting, then remove index bcoz it is out
            //of the current window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            //maintaining elements in decreasing order
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            if (i >= k - 1) {
                ans.add(arr[dq.peekFirst()]);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] method1(int[] arr, int k) {
        int n = arr.length;
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i <= n - k; i++) {
            int maxi = arr[i];
            for (int j = i; j < i + k; j++) {
                maxi = Math.max(maxi, arr[j]);
            }
            li.add(maxi);
        }
        return li.stream().mapToInt(Integer::intValue).toArray();
    }
}

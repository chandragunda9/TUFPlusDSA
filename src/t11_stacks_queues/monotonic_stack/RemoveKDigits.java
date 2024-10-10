package t11_stacks_queues.monotonic_stack;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String nums, int k) {
        int n = nums.length();
        Stack<Character> st = new Stack<>();

        for (int j = 0; j < n; j++) {
            char digit = nums.charAt(j);
            while (!st.isEmpty() && st.peek() > digit && k > 0) {
                st.pop();
                k--;
            }
            st.push(digit);
        }

        while (k > 0) {
            st.pop();
            k--;
        }
        if (st.isEmpty())
            return "0";

        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        while (ans.length() > 0 && ans.charAt(ans.length() - 1) == '0') {
            ans.deleteCharAt(ans.length() - 1);
        }
        ans.reverse();

        if (ans.length() == 0)
            return "0";
        return ans.toString();
    }

    public static void main(String[] args) {
        String str = "1002991";
        int k = 3;
        RemoveKDigits obj = new RemoveKDigits();
        System.out.println(obj.removeKdigits(str, k));
    }
}

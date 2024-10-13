package t11_stacks_queues.faqs;

import java.util.Stack;

public class BalancedParentheses {
    public boolean isValid(String str) {
        Stack<Character> st = new Stack<>();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                if (st.isEmpty())
                    return false;

                int top = st.pop();
                switch (ch) {
                    case ')': {
                        if (top == '{' || top == '[')
                            return false;
                        break;
                    }
                    case '}': {
                        if (top == '[' || top == '(')
                            return false;
                        break;
                    }
                    case ']': {
                        if (top == '{' || top == '(')
                            return false;
                        break;
                    }
                }
            }
        }
        return st.isEmpty();
    }
}

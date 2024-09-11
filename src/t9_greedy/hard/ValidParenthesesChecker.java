package t9_greedy.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ValidParenthesesChecker {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        List<Character> left = new ArrayList<>(Arrays.asList('(', '[', '{'));
//        List<Character> right = new ArrayList<>(Arrays.asList(')', ']', '}'));
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (left.contains(ch)) {
                st.push(ch);
                continue;
            }
            if (st.isEmpty())
                return false;
            char top = st.pop();
            switch (ch) {
                case ')': {
                    if (top == '[' || top == '{')
                        return false;
                    break;
                }
                case ']': {
                    if (top == '(' || top == '{')
                        return false;
                    break;
                }
                case '}': {
                    if (top == '[' || top == '(')
                        return false;
                    break;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s = "((){})";
        System.out.println(isValid(s));
    }
}

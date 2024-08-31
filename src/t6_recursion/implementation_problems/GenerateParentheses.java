package t6_recursion.implementation_problems;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        parentheses("", n, 0, 0, ans);
        return ans;
    }

    void parentheses(String s, int n, int left, int right, List<String> ans) {
        if (left == n && right == n) {
            ans.add(s);
            return;
        }
        if (left < n) {
            parentheses(s + '(', n, left + 1, right, ans);
        }
        if (right < left) {
            parentheses(s + ')', n, left, right + 1, ans);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses obj = new GenerateParentheses();
        int n = 3;
        System.out.println(obj.generateParenthesis(n));
    }
}

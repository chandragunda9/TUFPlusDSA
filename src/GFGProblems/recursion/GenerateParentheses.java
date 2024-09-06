package GFGProblems.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses obj = new GenerateParentheses();
        int n = 3;
        System.out.println(obj.AllParenthesis(n));
    }

    public List<String> AllParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(0, 0, "", n, ans);
        //Time: O(2^(2n))
        return ans;
    }

    void generate(int open, int close, String curr, int n, List<String> ans) {
        if (open == close && open == n) {
            ans.add(curr);
            return;
        }
        if (open < n) {
            generate(open + 1, close, curr + "(", n, ans);
        }
        if (close < open) {
            generate(open, close + 1, curr + ")", n, ans);
        }
    }
}

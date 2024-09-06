package GFGProblems.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSet {
    public List<String> AllPossibleStrings(String s) {
        List<String> ans = new ArrayList<>();
        generate(0, "", s, ans);
        Collections.sort(ans);
        //Time: O(2^N)
//      Space:  O(N * 2^N): We generate 2^n subsets, and each subset can have up to n elements.
//        Additionally, the recursion stack can go up to a depth of n.
        return ans;
    }

    public void generate(int ind, String curr, String str, List<String> ans) {
        if (ind == str.length()) {
            ans.add(curr);
            return;
        }
        //take case
        generate(ind + 1, curr + str.charAt(ind), str, ans);
        //not take case
        generate(ind + 1, curr, str, ans);
    }
}

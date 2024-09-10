package GFGProblems.bits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSet {
    public List<String> AllPossibleStrings(String s) {
        int n = s.length();
        int noOfSubsets = 1 << n;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < noOfSubsets; i++) {
            StringBuilder curr = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    curr.append(s.charAt(j));
                }
                if (!curr.toString().isEmpty())
                    ans.add(curr.toString());
            }
        }
        Collections.sort(ans);
        return ans;
    }
}

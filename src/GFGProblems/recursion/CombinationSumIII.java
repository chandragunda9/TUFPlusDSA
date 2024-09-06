package GFGProblems.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k > n)
            return new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        generate(1, n, k, curr, ans);
        return ans;
    }

    void generate(int val, int target, int k, List<Integer> curr, List<List<Integer>> ans) {
        if (target == 0 && curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (val > 9 || target <= 0 || curr.size() >= k)
            return;
        //take case
        curr.add(val);
        generate(val + 1, target - val, k, curr, ans);
        //not take case
        curr.remove(curr.size() - 1);
        generate(val + 1, target, k, curr, ans);
    }

    public static void main(String[] args) {
        int k = 3, n = 9;
        CombinationSumIII obj = new CombinationSumIII();
        System.out.println(obj.combinationSum3(k, n));
    }
}

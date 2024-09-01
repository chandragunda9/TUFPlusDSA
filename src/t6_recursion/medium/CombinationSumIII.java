package t6_recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int start = 1;
        findAllCombinations(start, k, n, curr, ans);
        return ans;
    }

    void findAllCombinations(int val, int k, int sum, List<Integer> curr, List<List<Integer>> ans) {
        if (curr.size() == k && sum == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (sum <= 0 || curr.size() >= k || val > 9)
            return;
        //take case
        curr.add(val);
        findAllCombinations(val + 1, k, sum - val, curr, ans);
        //not take case
        curr.remove(curr.size() - 1);
        findAllCombinations(val + 1, k, sum, curr, ans);
    }

    public static void main(String[] args) {
        CombinationSumIII obj = new CombinationSumIII();
        int k = 4, n = 10;
        System.out.println(obj.combinationSum3(k, n));
    }
}

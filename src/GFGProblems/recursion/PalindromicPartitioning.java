package GFGProblems.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartitioning {
    static int palindromicPartition(String str) {
        int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;
        getCuts(0, 0, str, ans);
        return ans[0];
    }

    static void getCuts(int ind, int count, String st, int[] ans) {
        if (ind == st.length()) {
            ans[0] = Math.min(ans[0], count - 1);
        }
        for (int i = ind; i < st.length(); i++) {
            if (isPalindrome(st.substring(ind, i + 1))) {
                getCuts(i + 1, count + 1, st, ans);
            }
        }
    }

    static boolean isPalindrome(String st) {
        int i = 0, j = st.length() - 1;
        while (i < j) {
            if (st.charAt(i++) != st.charAt(j--))
                return false;
        }
        return true;
    }


    public List<List<String>> partition(String s) {
        List<String> curr = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        generate(0, s, curr, ans);
        return ans;
    }

    void generate(int ind, String st, List<String> curr, List<List<String>> ans) {
        if (ind == st.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = ind; i < st.length(); i++) {
            String word = st.substring(ind, i + 1);
            if (isPalindrome(word)) {
                curr.add(word);
                generate(i + 1, st, curr, ans);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String st = "aabaa";
        System.out.println(PalindromicPartitioning.palindromicPartition(st));
        PalindromicPartitioning obj = new PalindromicPartitioning();
        System.out.println(obj.partition(st));
    }
}

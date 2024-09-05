package t6_recursion.faq_hard;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        findPartitions(0, curr, s, ans);
        return ans;
    }

    void findPartitions(int start, List<String> curr, String s, List<List<String>> ans) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            boolean isPalindrome = check(s.substring(start, i + 1));
            if (isPalindrome) {
                curr.add(s.substring(start, i + 1));
                findPartitions(i + 1, curr, s, ans);
                curr.remove(curr.size() - 1);
            }
        }
    }

    boolean check(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--))
                return false;
        }
        return true;
    }

    static int palindromicPartition(String str) {
        int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;
        findPartitions(0, str, 0, ans);
        return ans[0];
    }

    static void findPartitions(int start, String str, int count, int[] ans) {
        if (start == str.length()) {
            ans[0] = Math.min(ans[0], count - 1);
            return;
        }
        for (int i = start; i < str.length(); i++) {
            boolean isPalindrome = f(str.substring(start, i + 1));
            if (isPalindrome) {
                findPartitions(i + 1, str, count + 1, ans);
            }
        }
    }

    static boolean f(String st) {
        int i = 0, j = st.length() - 1;
        while (i < j) {
            if (st.charAt(i++) != st.charAt(j--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning obj = new PalindromePartitioning();
        String s = "ababbbabbababa";
        System.out.println(obj.partition(s));
        System.out.println(palindromicPartition(s));
    }
}

package GFGProblems.recursion;

import java.util.ArrayList;

public class LetterCombinationsOfPhoneNumber {
    static ArrayList<String> possibleWords(int a[], int N) {
        String[] letterCombs = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> ans = new ArrayList<>();
        generate(0, a, "", letterCombs, ans);
        return ans;
    }

    static void generate(int ind, int[] nums, String curr, String[] letters, ArrayList<String> ans) {
        if (ind == nums.length) {
            ans.add(curr);
            return;
        }
        String st = letters[nums[ind]];
        for (int i = 0; i < st.length(); i++) {
            generate(ind + 1, nums, curr + st.charAt(i), letters, ans);
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 4};
        System.out.println(LetterCombinationsOfPhoneNumber.possibleWords(a, a.length));
    }
}

package t6_recursion.hard;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        findCombinations(0, "", digits, map, ans);
        return ans;
    }

    void findCombinations(int ind, String curr, String digits, String[] map, List<String> ans) {
        if (ind == digits.length()) {
            ans.add(curr);
            return;
        }
//        String combs = map[Integer.parseInt(String.valueOf(digits.charAt(ind)))];
        String combs = map[digits.charAt(ind) - '0'];
        for (int i = 0; i < combs.length(); i++) {
            char ch = combs.charAt(i);
            findCombinations(ind + 1, curr + ch, digits, map, ans);
        }
    }

    public static void main(String[] args) {
        LetterCombinations obj=new LetterCombinations();
        System.out.println(obj.letterCombinations("34"));
    }
}

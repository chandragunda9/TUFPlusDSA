package t1_beginner_problems.basic_recursion;

public class PalindromeStringOrNot {
    public boolean palindromeCheck(String s) {
        return check(s, 0, s.length() - 1);
    }

    boolean check(String s, int l, int r) {
        if (l >= r)
            return true;
        return s.charAt(l) == s.charAt(r) && check(s, l + 1, r - 1);
    }
}

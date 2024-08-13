package t1_beginner_problems.basic_strings;

public class LargestOddNumberInAString {
    public static void main(String[] args) {
        String s = "504";
        System.out.println(largeOddNum(s));
    }

    public static String largeOddNum(String s) {
        int n = s.length(), r = n - 1, l = 0;
        while (r >= 0) {
            int digit = Integer.parseInt(s.substring(r, r + 1));
            if ((digit & 1) != 0) {
                break;
            }
            r--;
        }
        if (r < 0)
            return "";
        while (l < n && s.charAt(l) == '0') {
            l++;
        }
        return s.substring(l, r + 1);
    }
}

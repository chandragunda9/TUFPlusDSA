package t18_strings.advanced;

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String str = s + "$" + sb.toString();

        int[] LPS = computeLPSOptimal(str);
        int noOfCharsToBeAdded = s.length() - LPS[LPS.length - 1];
        return sb.substring(0, noOfCharsToBeAdded) + s;
    }

    //longest prefix suffix
    int[] computeLPSOptimal(String s) {
        int n = s.length();
        int i = 1, j = 0;

        int[] lps = new int[n];
        while (i < n) {
            if (s.charAt(i) == s.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                while (j > 0 && s.charAt(i) != s.charAt(j)) {
                    j = lps[j - 1];
                }
                if (s.charAt(i) == s.charAt(j)) {
                    lps[i] = j + 1;
                    j++;
                }
                i++;
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        String s="aacecaaa";
        ShortestPalindrome obj=new ShortestPalindrome();
        System.out.println(obj.shortestPalindrome(s));
    }
}

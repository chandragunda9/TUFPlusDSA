package t18_strings.medium;

public class MinBracketReversals {
    public int countRev(String s) {
        int open = 0, close = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(')
                open++;
            else if (s.charAt(i) == ')') {
                if (open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
            i++;
        }

        if (((open + close) & 1) != 0)
            return -1;
        return open / 2 + open % 2 + close / 2 + close % 2;
    }
}

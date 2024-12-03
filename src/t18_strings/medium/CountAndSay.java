package t18_strings.medium;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String prev = countAndSay(n - 1);
        StringBuilder res = new StringBuilder();
        int count = 1;
        for (int j = 1; j < prev.length(); j++) {
            if (prev.charAt(j) == prev.charAt(j - 1)) {
                count++;
            } else {
                res.append((char) ('0' + count));
                res.append(prev.charAt(j - 1));
                count = 1;
            }
        }
        res.append((char) ('0' + count));
        res.append(prev.charAt(prev.length() - 1));
        return res.toString();
    }
}

package t18_strings.advanced;

import java.util.ArrayList;
import java.util.List;

public class RabinKarpAlgorithm {
    public List<Integer> search(String pat, String txt) {
        int txtLen = txt.length(), patLen = pat.length();
        int txtHash = 0, patHash = 0;
        int p = 7, mod = 101;
        int patRight = 1, patLeft = 1;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < patLen; i++) {
            patHash += ((pat.charAt(i) - 'a' + 1) * patRight) % mod;
            txtHash += ((txt.charAt(i) - 'a' + 1) * patRight) % mod;
            patRight = (patRight * p) % mod;
        }

        for (int i = 0; i <= txtLen - patLen; i++) {
            if (txtHash == patHash) {
                if (txt.substring(i, i + patLen).equals(pat)) {
                    ans.add(i);
                }
            }

            if (i < txtLen - patLen) {
                txtHash = (txtHash - ((txt.charAt(i) - 'a' + 1) * patLeft) % mod + mod) % mod;
                txtHash = (txtHash + ((txt.charAt(i + patLen) - 'a' + 1) * patRight) % mod) % mod;
                patHash = (patHash * p) % mod;

                patRight = (patRight * p) % mod;
                patLeft = (patLeft * p) % mod;
            }
        }
        return ans;
    }
}

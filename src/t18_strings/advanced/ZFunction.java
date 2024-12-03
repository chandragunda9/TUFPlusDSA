package t18_strings.advanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZFunction {
    public ArrayList<Integer> search(String text, String pattern) {
        String str = pattern + "$" + text;
        int m = pattern.length();
//        List<Integer> Z = computeZArrayBrute(str);
        List<Integer> Z = computeZArrayOptimal(str);

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = m + 1; i < str.length(); i++) {
            if (Z.get(i) == m)
                ans.add(i - (m + 1));
        }
        return ans;
    }

    List<Integer> computeZArrayBrute(String s) {
        int n = s.length();
        List<Integer> Z = new ArrayList<>(Collections.nCopies(n, 0));
        for (int i = 1; i < n; i++) {
            while (i + Z.get(i) < n &&
                    s.charAt(i + Z.get(i)) == s.charAt(Z.get(i))) {
                Z.set(i, Z.get(i) + 1);
            }
        }
        return Z;
    }

    List<Integer> computeZArrayOptimal(String s) {
        int n = s.length();
        List<Integer> Z = new ArrayList<>(Collections.nCopies(n, 0));
        int l = 0, r = 0; //window
        for (int i = 1; i < n; i++) {
            if (i > r) {
                //outside the window
                while (i + Z.get(i) < n && s.charAt(i + Z.get(i)) == s.charAt(Z.get(i))) {
                    Z.set(i, Z.get(i) + 1);
                }
                l = i;
                r = i + Z.get(i) - 1;
            } else {
                //inside the window
//                if (i + Z.get(i - l) - 1 < r) {
                if (i + Z.get(i - l) <= r) {
                    Z.set(i, Z.get(i - l));
                } else {
                    Z.set(i, r - i + 1);
                    while (i + Z.get(i) < n && s.charAt(i + Z.get(i)) == s.charAt(Z.get(i))) {
                        Z.set(i, Z.get(i) + 1);
                    }
                    l = i;
                    r = i + Z.get(i) - 1;
                }
            }
        }
        return Z;
    }

    public static void main(String[] args) {
//        String s = "xyzabxyzabxyz";
//        String pat = "xyz";
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String pat = "aa";
        ZFunction obj = new ZFunction();
        System.out.println(obj.search(s, pat));
    }
}

package t19_maths;

import java.util.ArrayList;

public class CountPrimesLToR {
    int MAX = (int) 1e5;

    public ArrayList<Integer> primesInRange(ArrayList<int[]> queries) {
        int[] spf = new int[MAX + 1];
        int[] primesCount = new int[MAX + 1];
        ArrayList<Integer> ans = new ArrayList<>();

        boolean[] isPrimes = sieve(spf);

        for (int i = 2; i <= MAX; i++) {
            primesCount[i] = primesCount[i - 1];
            if (isPrimes[i])
                primesCount[i]++;
        }

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            if (l == 0 || l == 1) {
                ans.add(primesCount[r]);
            } else {
                ans.add(primesCount[r] - primesCount[l - 1]);
            }
        }
        return ans;
    }

    public boolean[] sieve(int[] spf) {
        boolean[] isPrimes = new boolean[MAX + 1];

        for (int i = 2; i <= MAX; i++) {
            isPrimes[i] = true;
        }

        for (int i = 2; i * i <= MAX; i++) {
            if (isPrimes[i]) {
                for (long val = (long) i * i; val <= MAX; val += i) {
                    isPrimes[(int) val] = false;
                }
            }
        }
        return isPrimes;
    }
}

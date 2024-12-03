package t19_maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintAllPrimesTillN {
    public ArrayList<Integer> primeTillN(int n) {
        //use of sieve of eratosthenes
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        for (long i = 2; i <= n; i++) {
            if (primes[(int) i]) {
                ans.add((int) i);
                for (long val = i * i; val <= n; val += i) {
                    primes[(int) val] = false;
                }
            }
        }
        return ans;
    }
}

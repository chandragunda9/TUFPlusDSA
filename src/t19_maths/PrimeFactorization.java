package t19_maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactorization {
    int MAX = (int) 1e5;

    public List<List<Integer>> primeFactors(int[] queries) {
        int[] spf = new int[MAX + 1];
        Arrays.fill(spf, 1);

        sieve(spf);
        List<List<Integer>> ans = new ArrayList<>();
        for (int q : queries) {
            ans.add(primeFact(q, spf));
        }
        return ans;
    }

    private void sieve(int[] spf) {
        for (int i = 2; i <= MAX; i++) {
            if (spf[i] == 1) {
                for (int val = i; val <= MAX; val += i) {
                    if (spf[val] == 1) {
                        spf[val] = i;
                    }
                }
            }
        }
    }

    public List<Integer> primeFact(int num, int[] spf) {
        List<Integer> primes = new ArrayList<>();
        while (num != 1) {
            primes.add(spf[num]);
            num = num / spf[num];
        }
        return primes;
    }

    public List<List<Integer>> method1(int[] queries) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            ans.add(primeFact(queries[i]));
        }
        return ans;
    }

    private List<Integer> primeFact(int num) {
        List<Integer> ans = new ArrayList<>();
        while (num % 2 == 0) {
            ans.add(2);
            num /= 2;
        }

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            while (num % i == 0) {
                ans.add(i);
                num /= i;
            }
        }
        if (num > 2) {
            ans.add(num);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] q = {7, 12, 18};
        PrimeFactorization obj = new PrimeFactorization();
        System.out.println(obj.primeFactors(q));
    }
}

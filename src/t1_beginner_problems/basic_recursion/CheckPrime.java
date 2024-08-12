package t1_beginner_problems.basic_recursion;

public class CheckPrime {
    public boolean checkPrime(int num) {
        return prime(num, 2);
    }

    boolean prime(int num, int x) {
        if (x > Math.sqrt(num))
            return true;
        if (num % x == 0)
            return false;
        return prime(num, ++x);
    }
}

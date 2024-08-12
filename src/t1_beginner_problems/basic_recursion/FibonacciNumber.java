package t1_beginner_problems.basic_recursion;

public class FibonacciNumber {
    public int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }
}

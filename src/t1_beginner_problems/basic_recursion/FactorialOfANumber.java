package t1_beginner_problems.basic_recursion;

public class FactorialOfANumber {
    public int factorial(int n) {
        if (n <= 1)
            return 1;
        return n * factorial(n - 1);
    }
}

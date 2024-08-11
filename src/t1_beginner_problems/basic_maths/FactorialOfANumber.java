package t1_beginner_problems.basic_maths;

public class FactorialOfANumber {
    public int factorial(int n) {
        int prod = 1;
        for (int i = 1; i <= n; i++) {
            prod *= i;
        }
        return prod;
    }
}

package t1_beginner_problems.basic_recursion;

public class SumOfNNumbers {
    public int NnumbersSum(int N) {
        if (N == 1)
            return 1;
        return N + NnumbersSum(N - 1);
    }
}

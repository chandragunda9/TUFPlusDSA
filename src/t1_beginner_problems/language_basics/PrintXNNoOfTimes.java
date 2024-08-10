package t1_beginner_problems.language_basics;

public class PrintXNNoOfTimes {
    public void printX(int X, int N) {
        if (N <= 0)
            return;
        for (int i = 1; i <= N; i++) {
            System.out.print(X);
            if (i <= N - 1)
                System.out.print(" ");
        }
        System.out.println();
    }
}

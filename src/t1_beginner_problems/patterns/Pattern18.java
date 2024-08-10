package t1_beginner_problems.patterns;

public class Pattern18 {
    public void pattern18(int n) {
        for (int i = 1; i <= n; i++) {
            int startAsciiVal = 65 + n - i;
            for (int j = 0; j < i; j++) {
                char ch = (char) (startAsciiVal + j);
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
}

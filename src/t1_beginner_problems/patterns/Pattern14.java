package t1_beginner_problems.patterns;

public class Pattern14 {
    public void pattern14(int n) {
        int startAsciiVal = 65;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                char ch = (char) (startAsciiVal + j);
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}

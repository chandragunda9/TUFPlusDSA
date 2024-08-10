package t1_beginner_problems.patterns;

public class Pattern15 {
    public void pattern15(int n) {
        int startAsciiVal = 65;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                char ch = (char) (startAsciiVal + j);
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}

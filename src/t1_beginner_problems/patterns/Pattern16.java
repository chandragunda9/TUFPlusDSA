package t1_beginner_problems.patterns;

public class Pattern16 {
    public void pattern16(int n) {
        int startAsciiVal = 65;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                char ch = (char) (startAsciiVal + i);
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}

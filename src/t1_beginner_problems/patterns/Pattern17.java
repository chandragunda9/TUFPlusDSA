package t1_beginner_problems.patterns;

public class Pattern17 {
    public void pattern17(int n) {
        for (int i = 0; i < n; i++) {
            //printing spaces
            for (int j = 1; j <= n - 1 - i; j++) {
                System.out.print(" ");
            }
            int noOfChars = 2 * i + 1, asciiVal = 65;
            for (int j = 0; j < noOfChars; j++) {
                int ind = (j <= noOfChars / 2) ? j : noOfChars - j - 1;
                char ch = (char) (asciiVal + ind);
                System.out.print(ch);
            }
            //printing spaces after characters printing
            for (int j = 1; j <= n - 1 - i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

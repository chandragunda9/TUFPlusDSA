package t1_beginner_problems.patterns;

public class Pattern19 {
    public void pattern19(int n) {
        int noOfRows = 2 * n;
        for (int rowInd = 0; rowInd < noOfRows; rowInd++) {
            int modifiedRowInd = rowInd >= noOfRows / 2 ? noOfRows - rowInd - 1 : rowInd;
            //finding no.of stars in a row
            int stars = n - modifiedRowInd;
            //printing stars
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            //printing spaces
            for (int j = 1; j <= 2 * modifiedRowInd; j++) {
                System.out.print(" ");
            }
            //printing stars
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

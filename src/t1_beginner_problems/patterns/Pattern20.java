package t1_beginner_problems.patterns;

public class Pattern20 {
    public void pattern20(int n) {
        int noOfRows = 2 * n - 1;
        for (int rowNo = 1; rowNo <= noOfRows; rowNo++) {
            int modifiedRowNo = rowNo <= n ? rowNo : 2 * n - rowNo;
            //printing stars
            for (int j = 1; j <= modifiedRowNo; j++) {
                System.out.print("*");
            }
            //printing spaces
            for (int j = 1; j <= 2 * (n - modifiedRowNo); j++) {
                System.out.print(" ");
            }
            //printing stars
            for (int j = 1; j <= modifiedRowNo; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

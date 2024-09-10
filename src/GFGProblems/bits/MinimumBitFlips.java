package GFGProblems.bits;

public class MinimumBitFlips {
    public static int minFlips(String S) {
        int flips1 = 0, flips2 = 0;
//        pattern1: 01010101....
//        pattern2: 10101010....
        for (int i = 0; i < S.length(); i++) {
            if (i % 2 == 0) {
                if (S.charAt(i) != '0') {
                    flips1++;
                } else {
                    flips2++;
                }
            } else {
                if (S.charAt(i) != '1') {
                    flips1++;
                } else {
                    flips2++;
                }
            }
        }
        return Math.min(flips1, flips2);
    }

    public static void main(String[] args) {
        String str = "0001010111";
        System.out.println(minFlips(str));
    }
}

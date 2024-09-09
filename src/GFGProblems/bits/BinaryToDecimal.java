package GFGProblems.bits;

public class BinaryToDecimal {
    public int binary_to_decimal(String str) {
        int ans = 0;
        int n = str.length(), pow = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) - '0' == 1)
                ans += pow * (str.charAt(i) - '0');
            pow = pow * 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        BinaryToDecimal obj = new BinaryToDecimal();
        System.out.println(obj.binary_to_decimal("1101"));
        System.out.println(~-5);
    }
}

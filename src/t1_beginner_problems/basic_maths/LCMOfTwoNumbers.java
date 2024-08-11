package t1_beginner_problems.basic_maths;

public class LCMOfTwoNumbers {
    public static void main(String[] args) {
        int n1 = 4, n2 = 6;
        System.out.println(method1(n1, n2));
    }

    public static int GCD(int n1, int n2) {
        while (n1 > 0 && n2 > 0) {
            if (n1 > n2) {
                n1 = n1 % n2;
            } else {
                n2 = n2 % n1;
            }
        }
        return n1 == 0 ? n2 : n1;
        //Time: O(log(min(n1, n2)))
    }

    public int LCM(int n1, int n2) {
        return n1 * n2 / GCD(n1, n2);
    }

    public static int method1(int n1, int n2) {
        int i = 1, max = Math.max(n1, n2);
        do {
            int mul = max * i;
            if (mul % n1 == 0 && mul % n2 == 0) {
                return mul;
            }
            i++;
        } while (true);
        //Time: O(min(n1, n2))
    }
}

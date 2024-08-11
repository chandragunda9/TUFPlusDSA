package t1_beginner_problems.basic_maths;

public class GCDOfTwoNumbers {
    public static void main(String[] args) {
        int n1 = 100, n2 = 15;
        System.out.println(method1(n1, n2));
        System.out.println(GCD(n1, n2));
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

    public static int method1(int n1, int n2) {
        int max = Math.min(n1, n2);
        for (int i = max; i >= 1; i--) {
            if (n1 % i == 0 && n2 % i == 0)
                return i;
        }
        return -1;
    }
}

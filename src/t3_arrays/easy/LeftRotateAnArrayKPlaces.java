package t3_arrays.easy;

public class LeftRotateAnArrayKPlaces {
    public void rotateArray(int[] nums, int d) {
        //By using Juggling algorithm
        int n = nums.length;
        d = d % n;
        int gcd = findGcd(n, d);
        //dividing array into gcd no.of sets
        for (int i = 0; i < gcd; i++) {
            int temp = nums[i];
            int j = i, k;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                nums[j] = nums[k];
                j = k;
            }
            nums[j] = temp;
        }
    }

    private int findGcd(int n1, int n2) {
        while (n1 > 0 && n2 > 0) {
            if (n1 >= n2) {
                n1 = n1 % n2;
            } else {
                n2 = n2 % n1;
            }
        }
        return n1 != 0 ? n1 : n2;
    }
}

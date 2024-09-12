package t6_recursion.medium;

public class SubsetWithXorK {
    //Refer GFG for this problem
    static int subsetXOR(int arr[], int N, int K) {
        return count(0, 0, K, arr, N);
    }

    static int count(int ind, int xor, int k, int[] arr, int n) {
        if (ind == n) {
            if (xor == k) {
                return 1;
            }
            return 0;
        }
        int c = 0;
        //take case
        c += count(ind + 1, xor ^ arr[ind], k, arr, n);
        //not take case
        c += count(ind + 1, xor, k, arr, n);
        return c;
    }

    public static void main(String[] args) {
        int[] arr = {6, 9, 4, 2};
        int K = 6;
        System.out.println(subsetXOR(arr, arr.length, K));
    }
}

package GFGProblems.recursion;

public class CheckSubsequenceExists {
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        return check(0, K, arr);
        //Time: 2^n
    }

    static boolean check(int ind, int target, int[] arr) {
        if (target == 0)
            return true;
        if (target < 0)
            return false;
        if (ind == arr.length)
            return false;
        return check(ind + 1, target - arr[ind], arr) || check(ind + 1, target, arr);
    }
}

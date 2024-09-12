package t3_arrays.medium;

public class CountOfSubarraysGreaterThanK {
    //Refer GFG for this problem
    long countSubarray(int arr[], int n, int k) {
        long count = 0;
        int prevInd = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > k) {
                count += (long) (i - prevInd) * (n - i);
                prevInd = i;
            }
        }
        return count;
    }
}

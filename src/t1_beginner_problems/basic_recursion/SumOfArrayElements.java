package t1_beginner_problems.basic_recursion;

public class SumOfArrayElements {
    public int sum(int arr[], int n) {
        return sum(arr, 0, n);
    }

    int sum(int[] arr, int ind, int n) {
        if (ind == n)
            return 0;
        return arr[ind] + sum(arr, ind + 1, n);
    }
}

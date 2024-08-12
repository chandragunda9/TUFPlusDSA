package t1_beginner_problems.basic_arrays;

public class ReverseArray {
    public int[] reverse(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++;
            r--;
        }
        return arr;
    }
}

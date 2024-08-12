package t1_beginner_problems.basic_recursion;

public class ReverseArray {
    public int[] reverse(int[] arr) {
        swap(arr, 0, arr.length - 1);
        return arr;
    }

    void swap(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        swap(arr, l + 1, r - 1);
    }
}

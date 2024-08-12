package t1_beginner_problems.basic_arrays;

public class CountOfOddNumbers {
    public int countOdd(int[] arr, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if ((arr[i] & 1) != 0)
                count += 1;
        }
        return count;
    }
}

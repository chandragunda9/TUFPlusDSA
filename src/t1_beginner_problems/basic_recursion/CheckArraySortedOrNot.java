package t1_beginner_problems.basic_recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CheckArraySortedOrNot {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 4, 5};
        ArrayList<Integer> al = Arrays.stream(arr).boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(isSorted(al));
    }

    static boolean isSorted(ArrayList<Integer> arr) {
        return check(arr, 0);
    }

    static boolean check(ArrayList<Integer> arr, int ind) {
        if (ind == arr.size() - 1)
            return true;
        if (arr.get(ind) > arr.get(ind + 1))
            return false;
        return check(arr, ind + 1);
    }
}

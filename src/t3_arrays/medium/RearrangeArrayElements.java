package t3_arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RearrangeArrayElements {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int pos = 0, neg = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans[pos] = nums[i];
                pos += 2;
            } else {
                ans[neg] = nums[i];
                neg += 2;
            }
        }
        return ans;
    }

    void rearrange(ArrayList<Integer> arr) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) >= 0)
                pos.add(arr.get(i));
            else
                neg.add(arr.get(i));
        }

        if (pos.size() > neg.size()) {
            for (int i = 0; i < neg.size(); i++) {
                arr.set(2 * i, pos.get(i));
                arr.set(2 * i + 1, neg.get(i));
            }
            int ind = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                arr.set(ind, pos.get(i));
                ind++;
            }
        } else {
            for (int i = 0; i < pos.size(); i++) {
                arr.set(2 * i, pos.get(i));
                arr.set(2 * i + 1, neg.get(i));
            }
            int ind = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                arr.set(ind, neg.get(i));
                ind++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {32, -38, 21, -14, 10, 2, -45, -23, 38, 48, 27, 20, 23, 48, 0, -36, -7, -23, 26, -7, -5, 0, -29, 21, -45, -16, -30, 22, -31, -22, 28, -39, -47, 32, -49, -47, -36, -8, -7, -36, -14, 0, -37, -32, 2, 39, -16, -38, 14, -6, -24, -3, 44, 4, -7, -34, -25, -37, -41, -2, -21, -1, -41, 1, -17, 27, 34, 15, -13, 0, -34, 17, -29};
        ArrayList<Integer> al = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
        RearrangeArrayElements obj = new RearrangeArrayElements();
        obj.rearrange(al);
        System.out.println(al);
    }
}

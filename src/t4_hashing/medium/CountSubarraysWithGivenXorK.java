package t4_hashing.medium;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithGivenXorK {
    public static void main(String[] args) {
        int[] nums = {5, 2, 9};
        int k = 7;
        System.out.println(subarraysWithXorK(nums, k));
    }

    public static int subarraysWithXorK(int[] nums, int k) {
        Map<Integer, Integer> prefixXors = new HashMap<>();
        prefixXors.put(0, 1);
        int xor = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            int rem = xor ^ k;
            if (prefixXors.containsKey(rem)) {
                count += prefixXors.get(rem);
            }
            prefixXors.put(xor, prefixXors.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
}

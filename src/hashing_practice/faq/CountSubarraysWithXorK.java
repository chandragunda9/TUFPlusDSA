package hashing_practice.faq;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithXorK {
    public int subarraysWithXorK(int[] nums, int k) {
        int xor = 0;
        int ans = 0;
        Map<Integer, Integer> prefixXors = new HashMap<>();
        prefixXors.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            int rem = xor ^ k;
            if (prefixXors.containsKey(rem)) {
                ans += prefixXors.get(rem);
            }
            prefixXors.put(xor, prefixXors.getOrDefault(xor, 0) + 1);
        }
        return ans;
    }
}

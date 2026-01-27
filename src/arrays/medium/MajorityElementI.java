package arrays.medium;

public class MajorityElementI {
    public int majorityElement(int[] nums) {
        //By using moore's voting algorithm
        int ele = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                ele = nums[i];
                count = 1;
            } else if (ele == nums[i]) {
                count += 1;
            } else {
                count -= 1;
            }
        }
        return ele;
    }
}

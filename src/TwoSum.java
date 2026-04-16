import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3, 3}, 6)));
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> storage = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int firstTerm = target - nums[i];
                if (storage.containsKey(firstTerm)) {
                    return new int[]{storage.get(firstTerm), i};
                    
                } else {
                    storage.put(nums[i], i);
                }
            }
            return new int[]{0, 0};
        }
    }
}

public class MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        boolean isDecreasing = true;
        boolean isIncreasing = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) isDecreasing = false;
            if (nums[i] < nums[i - 1]) isIncreasing = false;
        }

        return isDecreasing || isIncreasing;
    }
}

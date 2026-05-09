public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int lastNonZero = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[lastNonZero];
                nums[lastNonZero] = tmp;

                lastNonZero++;
            }
        }
    }
}
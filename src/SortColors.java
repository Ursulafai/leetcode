public class SortColors {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,0,2,1,1,0};

        solution.sortColors(nums);
    }

    static class Solution {
        public void sortColors(int[] nums) {
            int left = 0;
            int medium = 0;
            int right = nums.length - 1;


            while (medium <= right) {
                if (nums[medium] == 0) {
                    swap(nums, left, medium);

                    left++;
                    medium++;
                } else if (nums[medium] == 2) {
                    swap(nums, right, medium);

                    right--;
                } else {
                    medium++;
                }

            }
        }

        private static void swap(int[] nums, int left, int medium) {
            int tmp = nums[left];
            nums[left] = nums[medium];
            nums[medium] = tmp;
        }
    }
}

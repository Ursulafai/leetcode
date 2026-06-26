public class SearchInRotatedSortedArray {
    static void main() {
        System.out.println(search(new int[]{3, 1}, 1));

    }

    public static int search(int[] nums, int target) {
        if (nums.length == 1) return nums[0] == target ? 0 : -1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int medium = left + (right - left) / 2;
            if (target == nums[medium]) return medium;

            if (nums[left] <= nums[medium]) {
                if (target >= nums[left] && target < nums[medium]) {
                    right = medium - 1;
                } else {
                    left = medium + 1;
                }
            } else {
                if (target > nums[medium] && target <= nums[right]) {
                    left = medium + 1;
                } else {
                    right = medium - 1;
                }
            }
        }

        return -1;
    }
}

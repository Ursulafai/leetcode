public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];

        int l = 0;
        int r = nums.length - 1;
        int idx = r;

        while (l <= r) {
            int leftSq = nums[l] * nums[l];
            int rightSq = nums[r] * nums[r];
            if (rightSq > leftSq) {
                res[idx] = rightSq;
                r--;
            } else {
                res[idx] = leftSq;
                l++;
            }

            idx--;
        }

        return res;

    }
}

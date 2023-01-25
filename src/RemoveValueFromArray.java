import java.util.Arrays;

public class RemoveValueFromArray {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};

        System.out.println(removeElement(nums, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int indexToMove = 0;
        int time = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                if (indexToMove == 0 && time == 0) {
                    indexToMove = i;
                    time++;
                }
            } else {
                nums[indexToMove] = nums[i];
                indexToMove++;
            }
        }
        return indexToMove;
    }
}
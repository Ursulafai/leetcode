import java.util.Arrays;

public class RemoverDuplicates {
    public static void main(String[] args) {
        int[] array = {0, 0, 10, 10, 10, 20, 20, 30, 30, 45};
        System.out.println(removeDuplicates(array));
        System.out.println(Arrays.toString(array));
    }

    public static int removeDuplicates(int[] nums) {
        int indexToMove = 1;
        int currentValue;

        for (int i = 0; i < nums.length - 1; i++) {
            currentValue = nums[i];
            if (currentValue != nums[i + 1]) {
                nums[indexToMove] = nums[i + 1];
                indexToMove++;
            }
        }

        return indexToMove;
    }
}
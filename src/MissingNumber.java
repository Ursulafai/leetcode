public class MissingNumber {
    static void main() {
        System.out.println(missingNumber(new int[]{3, 0, 1}));
    }

    public static int missingNumber(int[] nums) {
        int missingInt = nums.length;

        for (int i = 0; i < nums.length; i++) {
            missingInt ^= i ^ nums[i];
        }

        return missingInt;
    }
}
import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    static void main() {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] resultArray = new int[nums.length];
        resultArray[0] = 1;

        int prefixProduct = 1;
        int suffixProduct = 1;

        for (int i = 1; i < nums.length; i++) {
            prefixProduct *= nums[i - 1];
            resultArray[i] = prefixProduct;
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            suffixProduct *= nums[i + 1];

            resultArray[i] *= suffixProduct;
        }

        return resultArray;
    }
}

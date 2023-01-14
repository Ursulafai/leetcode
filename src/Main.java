import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static boolean isPalindromeWithCastToString(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        char[] chars = String.valueOf(x).toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - (i + 1)])
                return false;
        }
        return true;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0)
            return false;

        int newNum = 0;
        while (x > newNum) {
            newNum = newNum * 10 + x % 10;
            x /= 10;
        }

        return x == newNum || x == newNum / 10;
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder commonPrefix = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {

            for (int j = 1; j < strs.length; j++) {
                if (!(strs[j].startsWith(commonPrefix.toString() + strs[0].charAt(i)))) {
                    return commonPrefix.toString();
                }
            }
            commonPrefix.append(strs[0].charAt(i));
        }

        return commonPrefix.toString();
    }
}
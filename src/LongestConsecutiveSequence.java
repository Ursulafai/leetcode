import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    static void main() {
        System.out.println(longestConsecutive(new int[]{1, 0, 1, 2}));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> storage = new HashSet<>();

        for (int j : nums) {
            storage.add(j);
        }

        int maxConsSeq = 0;
        for (int num : storage) {
            if (!storage.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                while (storage.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                maxConsSeq = Math.max(maxConsSeq, currentLength);
            }
        }

        return maxConsSeq;
    }
}

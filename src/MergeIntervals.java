import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }

    static class Solution {
        public int[][] merge(int[][] intervals) {

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            LinkedList<int[]> result = new LinkedList<>();

            int[] current = intervals[0];

            for (int i = 1; i < intervals.length; i++) {
                int[] next = intervals[i];

                if (next[0] <= current[1]) {
                    current[1] = Math.max(current[1], next[1]);
                } else {
                    result.add(current);
                    current = next;
                }

            }

            result.add(current);

            return result.toArray(new int[result.size()][]);
        }
    }
}

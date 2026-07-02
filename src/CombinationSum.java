import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);

        backTrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backTrack(int[] candidates, int remaining, int startIndex,
                           List<Integer> current, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] > remaining) break;
            current.add(candidates[i]);

            backTrack(candidates, remaining - candidates[i], i, current, result);

            current.removeLast();
        }
    }
}

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> storage = new HashSet<>();

        for (int num : nums) {
            if (!storage.add(num)) return true;
        }

        return false;

    }
}

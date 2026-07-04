import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(new String[]{"a"}));
    }

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {

            Map<String, List<String>> storage = new HashMap<>();

            for (String str : strs) {
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);
                String key = new String(charArray);

                storage.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
            }

            return new ArrayList<>(storage.values());
        }
    }
}
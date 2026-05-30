import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(new String[]{"a"}));
    }
    static class Solution {
        private final Map<String, List<String>> storage = new HashMap<>();
        public List<List<String>> groupAnagrams(String[] strs) {

            for (String str : strs) {
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);

                String string = Arrays.toString(charArray);
                if (storage.containsKey(string)) {
                    storage.get(string).add(str);
                } else {
                    storage.put(string, new LinkedList<>(List.of(str)));
                }
            }

            return (new LinkedList<>(storage.values()));
        }
    }
}
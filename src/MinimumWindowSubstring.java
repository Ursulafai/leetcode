import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int minLength = s.length() + 1;
        int start = 0;
        int l = 0;
        int r = 0;
        Map<Character, Integer> count = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int n = t.length();
        int m = s.length();

        if (m < n) return "";

        int foundInWindow = 0;

        for (int i = 0; i < n; i++) {
            count.merge(t.charAt(i), 1, Integer::sum);
        }

        int required = count.size();

        while (r < m) {
            char curr = s.charAt(r);

            window.merge(curr, 1, Integer::sum);

            if (window.get(curr).intValue() == count.getOrDefault(curr, 0).intValue()) {
                foundInWindow++;
            }

            while (l <= r && foundInWindow == required) {
                int currLength = r - l + 1;
                if (currLength < minLength) {
                    minLength = currLength;
                    start = l;
                }
                char charToRemove = s.charAt(l);

                window.merge(charToRemove, -1, Integer::sum);

                if (count.containsKey(charToRemove) && count.get(charToRemove) > window.get(charToRemove)) {
                    foundInWindow--;
                }

                l++;
            }
            r++;
        }

        return minLength == s.length() + 1 ? "" : s.substring(start, start + minLength);

    }

}

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxSize = 0;
        HashSet<Character> uniqueElements = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            char nextChar = s.charAt(right);

            while (uniqueElements.contains(nextChar)) {
                uniqueElements.remove(s.charAt(left));
                left++;
            }

            uniqueElements.add(nextChar);

            maxSize = Math.max(maxSize, right - left + 1);
        }
        return maxSize;
    }

    public int lengthOfLongestSubstringWithConstantMemory(String s) {
        boolean[] added = new boolean[128];

        int l = 0;
        int max = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            while (added[c]) {
                added[s.charAt(l)] = false;
                l++;
            }

            added[c] = true;
            max = Math.max(max, r - l + 1);
        }

        return max;

    }
}

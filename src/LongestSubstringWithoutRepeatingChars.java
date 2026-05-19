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

}

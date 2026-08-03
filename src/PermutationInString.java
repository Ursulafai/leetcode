import java.util.Arrays;

public class PermutationInString {

    public static final int ALPHABET_SIZE = 26;

    public boolean checkInclusion(String s1, String s2) {
        int[] array1 = new int[ALPHABET_SIZE];
        int[] array2 = new int[ALPHABET_SIZE];

        int l1 = s1.length();
        int l2 = s2.length();

        if (l2 < l1) return false;

        for (char c : s1.toCharArray()) {
            array1[c - 'a']++;
        }

        for (int i = 0; i < l1; i++) {
            array2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(array1, array2)) return true;

        for (int i = l1; i < l2; i++) {
            array2[s2.charAt(i) - 'a']++;
            array2[s2.charAt(i - l1) - 'a']--;

            if (Arrays.equals(array1, array2)) return true;
        }

        return false;

    }

    public boolean checkInclusionWithMatches(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        if (l2 < l1) return false;

        int[] array1 = new int[ALPHABET_SIZE];
        int[] window = new int[ALPHABET_SIZE];

        int matches = 0;

        for (char c : s1.toCharArray()) {
            array1[c - 'a']++;
        }

        for (int i = 0; i < l1; i++) {
            window[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (array1[i] == window[i]) matches++;
        }

        if (matches == ALPHABET_SIZE) return true;

        for (int i = l1; i < l2; i++) {
            int addedIdx = s2.charAt(i) - 'a';
            int removedIdx = s2.charAt(i - l1) - 'a';

            if (addedIdx == removedIdx) {
                continue;
            }

            window[addedIdx]++;
            window[removedIdx]--;

            if (window[addedIdx] == array1[addedIdx]) matches++;
            else if (window[addedIdx] == array1[addedIdx] + 1) matches--;

            if (window[removedIdx] == array1[removedIdx]) matches++;
            else if (window[removedIdx] == array1[removedIdx] - 1) matches--;

            if (matches == ALPHABET_SIZE) return true;
        }

        return false;

    }
}

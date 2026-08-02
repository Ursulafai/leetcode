import java.util.Arrays;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] array1 = new int[26];
        int[] array2 = new int[26];

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
}

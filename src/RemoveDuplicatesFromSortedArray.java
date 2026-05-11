public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int lastUniqueIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[lastUniqueIndex]) {
                nums[lastUniqueIndex + 1] = nums[i];
                lastUniqueIndex++;
            }
        }
        return lastUniqueIndex + 1;
    }
}

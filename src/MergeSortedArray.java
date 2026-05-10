public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int firstPointer = m - 1;
        int secondPointer = n - 1;
        int counter = m + n - 1;

        while (secondPointer >= 0) {
            if (firstPointer >= 0 && nums1[firstPointer] > nums2[secondPointer]) {
                nums1[counter] = nums1[firstPointer];
                firstPointer--;
            } else {
                nums1[counter] = nums2[secondPointer];
                secondPointer--;
            }
            counter--;
        }
    }
}

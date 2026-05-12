public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxSquare = 0;
        int rightIndex = height.length - 1;
        int leftIndex = 0;

        while (leftIndex < rightIndex) {
            int newSquare = (Math.min(height[rightIndex], height[leftIndex])) * (rightIndex - leftIndex);

            maxSquare = Math.max(maxSquare, newSquare);

            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return maxSquare;

    }
}

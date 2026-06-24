import java.util.*;

public class TopKFrequentElements {
    static void main() {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 2, 1, 2, 1, 2, 3, 1, 3, 2}, 2)));
    }

    record Task(int freq, int num) {
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> storage = new HashMap<>();
        PriorityQueue<Task> minHeap = new PriorityQueue<>(Comparator.comparingInt(Task::freq));

        int[] resultArray = new int[k];

        if (k >= nums.length) {
            return Arrays.stream(nums).distinct().toArray();
        }

        for (int current : nums) {
            storage.merge(current, 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> entry : storage.entrySet()) {
            minHeap.offer(new Task(entry.getValue(), entry.getKey()));

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        for (int i = 0; i < k; i++) {

            Task task = minHeap.poll();
            if (task != null) {
                resultArray[i] = task.num;
            }
        }
        return resultArray;
    }
}

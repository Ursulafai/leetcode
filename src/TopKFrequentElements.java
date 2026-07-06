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

    public int[] topKFrequentBuckets(int[] nums, int k) {
        Map<Integer, Integer> freqStorage = new HashMap<>();
        ArrayList<Integer>[] buckets = new ArrayList[nums.length + 1];
        int[] res = new int[k];

        for (int num : nums) {
            freqStorage.merge(num, 1, Integer::sum);
        }

        for (int key : freqStorage.keySet()) {
            int value = freqStorage.get(key);
            if (buckets[value] == null) {
                buckets[value] = new ArrayList<>();
            }

            buckets[value].add(key);
        }
        int idx = 0;
        for (int i = nums.length; i >= 0 && idx < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    res[idx++] = num;
                    if (idx > k) return res;
                }
            }
        }

        return res;
    }
}

import java.util.*;

public class KtopElement {

    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min-heap based on frequency
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.offer(new int[] { entry.getValue(), entry.getKey() });
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 3: Extract results from heap
        int[] ans = new int[minHeap.size()];
        int index = 0;
        while (!minHeap.isEmpty()) {
            ans[index++] = minHeap.poll()[1];
        }

        return ans;
    }

    public static void main(String[] args) {
        KtopElement sol = new KtopElement();

        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;

        System.out.println("Given Array: " + Arrays.toString(nums));

        int[] result = sol.topKFrequent(nums, k);
        System.out.println("Top " + k + " Frequent Elements: " + Arrays.toString(result));
    }
}

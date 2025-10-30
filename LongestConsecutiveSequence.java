import java.util.*;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxSize = 0;

        for (int num : set) {
            // Only start counting if it's the beginning of a sequence
            if (!set.contains(num - 1)) {
                int size = 1;
                int currentVal = num;

                // Count consecutive numbers
                while (set.contains(currentVal + 1)) {
                    size++;
                    currentVal++;
                }

                maxSize = Math.max(maxSize, size);
            }
        }

        return maxSize;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence sol = new LongestConsecutiveSequence();

        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println("Given Array: " + Arrays.toString(nums));

        int result = sol.longestConsecutive(nums);
        System.out.println("Longest Consecutive Sequence Length: " + result);
    }
}

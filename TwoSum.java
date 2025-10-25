import java.util.HashMap;
import java.util.Arrays;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Store each number's value and its index
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        // Check for the complement
        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (map.containsKey(rem) && map.get(rem) != i) {
                return new int[] { i, map.get(rem) };
            }
        }

        return new int[] {}; // Return empty array if not found
    }

    public static void main(String[] args) {
        TwoSum sol = new TwoSum();

        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        int[] result = sol.twoSum(nums, target);
        System.out.println("Indices: " + Arrays.toString(result));
    }
}

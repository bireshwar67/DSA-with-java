import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array first

        for (int i = 0; i < nums.length; i++) {
            // Skip duplicate numbers for i
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    // Skip duplicate numbers for j
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    // Skip duplicate numbers for k
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum sol = new ThreeSum();

        int[] nums = { -1, 0, 1, 2, -1, -4 };
        System.out.println("Given Array: " + Arrays.toString(nums));

        List<List<Integer>> result = sol.threeSum(nums);
        System.out.println("Triplets that sum to zero: " + result);
    }
}

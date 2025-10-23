public class Kadane {

    public int maxSubArray(int[] nums) {
        int presentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            presentSum += nums[i];
            maxSum = Math.max(maxSum, presentSum);

            if (presentSum < 0) {
                presentSum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Kadane sol = new Kadane();

        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int result = sol.maxSubArray(nums);

        System.out.println("Maximum Subarray Sum: " + result);
    }
}

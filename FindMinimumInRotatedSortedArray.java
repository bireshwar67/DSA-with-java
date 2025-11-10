public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return nums[low];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray sol = new FindMinimumInRotatedSortedArray();

        int[] nums1 = { 3, 4, 5, 1, 2 };
        int[] nums2 = { 4, 5, 6, 7, 0, 1, 2 };
        int[] nums3 = { 11, 13, 15, 17 };

        System.out.println("Minimum in nums1: " + sol.findMin(nums1)); // 1
        System.out.println("Minimum in nums2: " + sol.findMin(nums2)); // 0
        System.out.println("Minimum in nums3: " + sol.findMin(nums3)); // 11
    }
}

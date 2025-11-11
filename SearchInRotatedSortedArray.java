public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Handle duplicates (only needed if array may contain duplicates)
            if (nums[low] == nums[mid] && nums[high] == nums[mid]) {
                low++;
                high--;
            }
            // Left half is sorted
            else if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray sol = new SearchInRotatedSortedArray();

        int[] nums1 = { 4, 5, 6, 7, 0, 1, 2 };
        int[] nums2 = { 2, 5, 6, 0, 0, 1, 2 };
        int target1 = 0;
        int target2 = 3;

        System.out.println("Searching " + target1 + " Index: " + sol.search(nums1, target1)); // 4
        System.out.println("Searching " + target2 + " Index: " + sol.search(nums1, target2)); // -1
        System.out.println("Searching 0 in nums2 Index: " + sol.search(nums2, 0)); // Could be 3 or 4
    }
}

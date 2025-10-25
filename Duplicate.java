import java.util.HashMap;

public class Duplicate {

    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int count : map.values()) {
            if (count > 1) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Duplicate sol = new Duplicate();

        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 2, 3, 1};

        System.out.println("nums1 has duplicate: " + sol.hasDuplicate(nums1)); // false
        System.out.println("nums2 has duplicate: " + sol.hasDuplicate(nums2)); // true
    }
}

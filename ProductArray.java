import java.util.*;

public class ProductArray {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        int prefixProd = 1;
        for (int i = 0; i < n; i++) {
            ans[i] *= prefixProd;
            prefixProd *= nums[i];
        }

        int suffixProd = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= suffixProd;
            suffixProd *= nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        ProductArray sol = new ProductArray();

        int[] nums = { 1, 2, 3, 4 };
        System.out.println("Given Array: " + Arrays.toString(nums));

        int[] result = sol.productExceptSelf(nums);
        System.out.println("Product Except Self: " + Arrays.toString(result));
    }
}

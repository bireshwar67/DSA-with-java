public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int mostWater = 0;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            mostWater = Math.max(area, mostWater);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return mostWater;
    }

    public static void main(String[] args) {
        ContainerWithMostWater sol = new ContainerWithMostWater();

        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println("Heights: " + java.util.Arrays.toString(height));

        int result = sol.maxArea(height);
        System.out.println("Maximum area of water: " + result);
    }
}

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            // Keep track of the minimum price seen so far
            minPrice = Math.min(minPrice, price);

            // Calculate potential profit if sold today
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock sol = new BestTimeToBuyAndSellStock();

        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println("Stock prices: " + java.util.Arrays.toString(prices));

        int profit = sol.maxProfit(prices);
        System.out.println("Maximum profit: " + profit);
    }
}

import java.util.Arrays;

class Solution7 {
    public int maxProfit(int[] prices) {
        // Safe check for empty or null arrays
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int buy_price = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy_price) {
                buy_price = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - buy_price);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        Solution7 s = new Solution7();
        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println(s.maxProfit(prices)); // Output: 5
    }
}

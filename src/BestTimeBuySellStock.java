public class BestTimeBuySellStock {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}));

    }

    static class Solution {
        public int maxProfit(int[] prices) {
            int minPrice = prices[0];
            int maxProfit = 0;

            for (int price : prices) {
                minPrice = Math.min(minPrice, price);
                maxProfit = Math.max(maxProfit, price - minPrice);
            }

            return maxProfit;

        }

        public int maxProfitWithWindow(int[] prices) {
            int l = 0;
            int r = l + 1;
            int profit = 0;

            while (r < prices.length) {
                if (prices[r] < prices[l]) {
                    l = r;
                } else {
                    profit = Math.max(profit, prices[r] - prices[l]);
                }

                r++;
            }

            return profit;

        }
    }

}

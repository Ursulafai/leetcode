public class BestTimeBuySellStock {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.maxProfit(new int[] {7,6,4,3,1}));

    }

    static class Solution {
        public int maxProfit(int[] prices) {
            int buy = prices[0];
            int sell;
            int profit = 0;

            for (int price : prices) {
                if (price < buy) {
                    buy = price;
                }

                sell = price;

                profit = Math.max(profit, sell - buy);

            }

            return profit;
        }
    }

}

package t16_dynamic_programming.stocks;

public class BestTimeToBuyAndSellStock {
    public int stockBuySell(int[] arr, int n) {
        int profit = 0;
        int minCost = arr[0];
        for (int i = 0; i < n; i++) {
            int currProfit = arr[i] - minCost;
            profit = Math.max(profit, currProfit);
            minCost = Math.min(minCost, arr[i]);
        }
        return profit;
    }
}

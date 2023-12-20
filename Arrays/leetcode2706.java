class Solution {
    public int buyChoco(int[] prices, int money) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length - 1; i++){
            for (int j = i + 1; j < prices.length; j++){
                if (prices[i] + prices[j] <= money){
                    max = Math.max(money - prices[i] - prices[j], max);
                }
            }
        }
        if (max != Integer.MIN_VALUE){
            return max;
        }
        return money;
    }
}
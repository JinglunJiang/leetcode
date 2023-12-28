class Solution {
    public int maxProfit(int[] prices) {
        int curDiff = 0;
        int sum = 0;
        for (int i = 1; i < prices.length; i++){
            curDiff = prices[i] - prices[i - 1];
            if (curDiff > 0){
                sum += curDiff;
            }
        }
        return sum;
    }
}
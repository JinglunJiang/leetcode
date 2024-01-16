class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int j = 1;
        int result = 0;
        while (j < prices.length){
            if (prices[j] > prices[i]){
                result = Math.max(result, prices[j] - prices[i]);
                j++;
            }
            else{
                i = j;
                j = i + 1;
            }
        }
        return result;
    }
}
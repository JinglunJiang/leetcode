class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1){
            return nums.length;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
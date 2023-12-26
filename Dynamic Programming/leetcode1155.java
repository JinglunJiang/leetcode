class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int MOD = 1000000007;
        int[][] dp = new int[n + 1][target + 1];

        // Base case: one way to get a sum of 0 with 0 dice
        dp[0][0] = 1;

        // Calculate the number of ways to get each sum using different numbers of dice
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                // Calculate the number of ways to get the current sum
                for (int face = 1; face <= k; face++) {
                    if (j - face >= 0) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - face]) % MOD;
                    }
                }
            }
        }

        return dp[n][target];
    }
}
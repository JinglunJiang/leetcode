class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        boolean flag = false;
        for (int i = 0; i < m; i++){
            if (!flag && obstacleGrid[i][0] == 0){
                dp[i][0] = 1;
            }
            else{
                dp[i][0] = 0;
                flag = true;
            }
        }
        boolean flag2 = false;
        for (int i = 0; i < n; i++){
            if (!flag2 && obstacleGrid[0][i] == 0){
                dp[0][i] = 1;
            }
            else{
                dp[0][i] = 0;
                flag2 = true;
            }
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--){
            for (int j = i; j < s.length(); j++){
                if (i == j){
                    dp[i][j] = true;
                }
                else if (j - i == 1 && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                }
                else{
                    if (s.charAt(j) == s.charAt(i) && dp[i + 1][j - 1]){
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j] == true){
                    count++;
                }
            }
        }
        return count;
    }
}
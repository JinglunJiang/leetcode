class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--){
            for (int j = i; j < s.length(); j++){
                if (j - i == 0){
                    dp[i][j] = true;
                    count++;
                }
                else if (j - i == 1 && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                    count++;
                }
                else {
                    if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
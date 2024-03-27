class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--){
            for (String str : wordDict){
                if (i + str.length() <= s.length()){
                    if (s.substring(i, i + str.length()).equals(str) && dp[i + str.length()]){
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[0];
    }
}
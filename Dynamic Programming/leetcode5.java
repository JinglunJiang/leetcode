class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1){
            return s;
        }
        int left = 0;
        int right = 0;
        int maxLength = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--){
            for (int j = i; j < s.length(); j++){
                if (j - i == 0){
                    dp[i][j] = true;
                }
                else if (j - i == 1 && s.charAt(j) == s.charAt(i)){
                    dp[i][j] = true;
                }
                else if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                }
                if (dp[i][j] && j - i + 1 > maxLength){
                    left = i;
                    right = j;
                    maxLength = j - i + 1;
                }
            }
        }
        String result = s.substring(left, right + 1);
        return result;
    }
}
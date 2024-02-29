class Solution {
    public String longestPalindrome(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--){
            for (int j = i; j < s.length(); j++){
                if (i == j){
                    dp[i][j] = true;
                }
                else if (j - i == 1){
                    if (s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                        if (j - i + 1 > maxLength){
                            maxLength = j - i + 1;
                            left = i;
                            right = j;
                        }
                    }
                }
                else{
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]){
                        dp[i][j] = true;
                        if (j - i + 1 > maxLength){
                            left = i;
                            right = j;
                            maxLength = j - i + 1;
                        }
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
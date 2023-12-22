class Solution {
    public int maxScore(String s) {
        int ones = 0;
        for (char c : s.toCharArray()){
            if (c == '1'){
                ones++;
            }
        }
        int max = 0;
        int zeros = 0;
        for (int i = 0; i < s.length() - 1; i++){
            if (s.charAt(i) == '0'){
                zeros++;
            }
            else{
                ones--;
            }
            max = Math.max(ones + zeros, max);
        }
        return max;
    }
}
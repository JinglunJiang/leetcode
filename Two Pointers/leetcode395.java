class Solution {
    public int longestSubstring(String s, int k) {
        char[] dictionary = new char[26];
        for (int i = 0; i < s.length(); i++){
            dictionary[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++){
            if (dictionary[s.charAt(i) - 'a'] < k){
                int j = i + 1;
                while (j < s.length() && dictionary[s.charAt(j) - 'a'] < k){
                    j++;
                }
                return Math.max(longestSubstring(s.substring(0, i), k), longestSubstring(s.substring(j), k));
            }
        }
        return s.length();
    }
}
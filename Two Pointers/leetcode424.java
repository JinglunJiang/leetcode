class Solution {
    public int characterReplacement(String s, int k) {
        char[] dictionary = new char[26];
        int i = 0;
        int max = 0;
        int result = 0;
        for (int j = 0; j < s.length(); j++){
            dictionary[s.charAt(j) - 'A']++;
            max = Math.max(max, dictionary[s.charAt(j) - 'A']);
            if (j - i + 1 <= max + k){
                result = j - i + 1;
            }
            else{
                dictionary[s.charAt(i) - 'A']--;
                i++;
            }
        }
        return result;
    }
}
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] dictionary = new int[26];
        for (char c : s.toCharArray()){
            dictionary[c - 'a']++;
        }
        for (char c : t.toCharArray()){
            dictionary[c - 'a']--;
        }
        for (int i = 0; i < 26; i++){
            if (dictionary[i] != 0){
                return false;
            }
        }
        return true;
    }
}
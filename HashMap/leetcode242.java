class Solution {
    public boolean isAnagram(String s, String t) {
        int[] dict = new int[26];
        for (char c : s.toCharArray()){
            dict[c - 'a']++;
        }
        for (char c : t.toCharArray()){
            dict[c - 'a']--;
        }
        for (int i = 0; i < 26; i++){
            if (dict[i] != 0){
                return false;
            }
        }
        return true;
    }
}
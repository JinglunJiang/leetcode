class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] dictionary = new int[26];
        for (char c : s1.toCharArray()){
            dictionary[c - 'a']++;
        }
        int[] current = new int[26];
        for (int i = 0; i < s2.length(); i++){
            current[s2.charAt(i) - 'a']++;
            if (i >= s1.length()){
                current[s2.charAt(i - s1.length()) - 'a']--;
            }
            if (identical(dictionary, current)){
                return true;
            }
        }
        return false;
    }

    public boolean identical(int[] s1, int[] s2){
        for (int i = 0; i < 26; i++){
            if (s1[i] != s2[i]){
                return false;
            }
        }
        return true;
    }
}
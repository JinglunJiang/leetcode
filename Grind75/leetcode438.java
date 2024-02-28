class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] dictionary = new int[26];
        for (char c : p.toCharArray()){
            dictionary[c - 'a']++;
        }
        int i = 0;
        int[] check = new int[26];
        for (int j = 0; j < s.length(); j++){
            check[s.charAt(j) - 'a']++;
            if (j - i + 1 > p.length()){
                check[s.charAt(i) - 'a']--;
                i++;
            }
            if (j - i + 1 == p.length() && isAnagram(dictionary, check)){
                result.add(i);
            }
        }
        return result;
    }

    public boolean isAnagram(int[] dictionary, int[] check){
        for (int i = 0; i < 26; i++){
            if (dictionary[i] != check[i]){
                return false;
            }
        }
        return true;
    }
}
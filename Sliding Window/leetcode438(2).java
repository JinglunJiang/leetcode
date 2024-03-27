class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] target = new int[26];
        for (char c : p.toCharArray()){
            target[c - 'a']++;
        }
        List<Integer> result = new ArrayList<>();
        int[] current = new int[26];
        int i = 0;
        for (int j = 0; j < s.length(); j++){
            current[s.charAt(j) - 'a']++;
            while (j - i + 1 > p.length()){
                current[s.charAt(i) - 'a']--;
                i++;
            }
            if (j - i + 1 == p.length() && checkIdentical(current, target)){
                result.add(i);
            }
        }
        return result;
    }
    public boolean checkIdentical(int[] first, int[] second){
        for (int i = 0; i < 26; i++){
            if (first[i] != second[i]){
                return false;
            }
        }
        return true;
    }
}
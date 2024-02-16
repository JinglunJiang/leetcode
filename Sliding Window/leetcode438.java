class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] hashmap = new int[26];
        for (char c : p.toCharArray()){
            hashmap[c - 'a']++;
        }
        int[] current = new int[26];
        int i = 0;
        int j = 0;
        while (j < s.length()){
            current[s.charAt(j) - 'a']++;
            if (j - i + 1 > p.length()){
                current[s.charAt(i) - 'a']--;
                i++;
            }
            if (j - i + 1 == p.length() && isEqual(current, hashmap)){
                result.add(i);
            }
            j++;
        }
        return result;
    }

    public boolean isEqual(int[] first, int[] second){
        for (int i = 0; i < 26; i++){
            if (first[i] != second[i]){
                return false;
            }
        }
        return true;
    }
}
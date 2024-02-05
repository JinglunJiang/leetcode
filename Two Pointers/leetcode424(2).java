class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int result = k;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0; 
        for (int j = 0; j < s.length(); j++){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            max = Math.max(map.get(s.charAt(j)), max);
            if (j - i + 1 - max <= k){
                result = Math.max(result, j - i + 1);
            }
            else{
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
            }
        }
        return result;
    }
}
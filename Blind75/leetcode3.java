class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int i = 0;
        int max = 1;
        for (int j = 0; j < s.length(); j++){
            while (set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            max = Math.max(j - i + 1, max);
        }
        return max;
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0;
        int maxLength = 0;
        for (int j = 0; j < s.length(); j++){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                maxLength = Math.max(maxLength, set.size());
            }
            else{
                while(s.charAt(i) != s.charAt(j)){
                    set.remove(s.charAt(i));
                    i++;
                }
                i++;
            }
        }
        return maxLength;
    }
}
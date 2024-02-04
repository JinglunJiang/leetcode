class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1){
            return s.length();
        }
        int max = 1;
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        while (j < s.length()){
            if (set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }
            else{
                max = Math.max(j - i + 1, max);
                set.add(s.charAt(j));
                j++;
            }
        }
        return max;
    }
}
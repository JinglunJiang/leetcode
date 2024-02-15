class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int i = 0;
        int j = 0;
        while (j < s.length()){
            while (set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}
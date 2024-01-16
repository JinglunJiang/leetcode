class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1){
            return s.length();
        }
        Set<Character> set = new HashSet<>();
        int result = 0;
        int i = 0;
        int j = 0;
        while (j < s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                result = Math.max(result, j - i + 1);
                j++;
            }
            else{
                while(set.contains(s.charAt(j))){
                    set.remove(s.charAt(i));
                    i++;
                }
            }
        }
        return result;
    }
}
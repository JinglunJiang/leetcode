class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int length = 0;
        for (char c : s.toCharArray()){
            if (set.contains(c)){
                length += 2;
                set.remove(c);
            }
            else{
                set.add(c);
            }
        }
        if (s.length() > length){
            length++;
        }
        return length;
    }
}
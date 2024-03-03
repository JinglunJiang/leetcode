class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j){
            while (!Character.isLetterOrDigit(s.charAt(i)) && i < j){
                i++;
            }
            while (!Character.isLetterOrDigit(s.charAt(j)) && i < j){
                j--;
            }
            char first = Character.toLowerCase(s.charAt(i));
            char second = Character.toLowerCase(s.charAt(j));
            if (first != second){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
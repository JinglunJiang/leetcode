class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j){
            while (!Character.isLetterOrDigit(s.charAt(i)) && i < s.length() - 1 && i < j){
                i++;
            }
            while (!Character.isLetterOrDigit(s.charAt(j)) && j > 0 && i < j){
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
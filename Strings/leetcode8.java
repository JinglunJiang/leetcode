class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0){
            return 0;
        }
        int index = 0;
        int isNegative = 1;
        int result = 0;
        if (s.charAt(0) == '+'){
            index++;
        }
        if (s.charAt(0) == '-'){
            isNegative = -1;
            index++;
        }
        while (index < s.length() && Character.isDigit(s.charAt(index))){
            if (result > (Integer.MAX_VALUE - (s.charAt(index) - '0'))/ 10){
                if (isNegative == -1){
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }
            result = result * 10 + s.charAt(index) - '0';
            index++;
        }
        return (int)(result * isNegative);
    }
}
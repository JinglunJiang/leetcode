class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() < numRows){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++){
            int incrementor = (numRows - 1) * 2;
            for (int j = i; j < s.length(); j += incrementor){
                sb.append(s.charAt(j));
                if (i > 0 && i < numRows - 1 && j + incrementor - 2 * i < s.length()){
                    sb.append(s.charAt(j + incrementor - 2 * i));
                }
            }
        }
        return sb.toString();
    }
}
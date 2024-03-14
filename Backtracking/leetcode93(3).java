class Solution {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0, 0);
        return result;
    }

    public void backtracking(String s, int index, int pointNumber){
        if (pointNumber == 3 && isValid(s.substring(index))){
            result.add(s);
            return;
        }
        for (int i = index; i < s.length(); i++){
            if (isValid(s.substring(index, i + 1))){
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                backtracking(s, i + 2, pointNumber + 1);
                s = s.substring(0, i + 1) + s.substring(i + 2);
            }
        }
    }

    public boolean isValid(String s){
        if (s.length() > 1 && s.charAt(0) == '0'){
            return false;
        }
        for (char c : s.toCharArray()){
            if (!Character.isDigit(c)){
                return false;
            }
        }
        if (s.length() > 3 || s.length() == 0){
            return false;
        }
        int value = Integer.parseInt(s);
        if (value < 0 || value > 255){
            return false;
        }
        return true;
    }
}
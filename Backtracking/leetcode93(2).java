class Solution {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0, 0);
        return result;
    }

    private void backtracking(String s, int index, int pointnum){
        if (pointnum == 3 && isValid(s.substring(index))){
            String string = new String(s);
            result.add(s);
            return;
        }
        for (int i = index; i < s.length(); i++){
            if (isValid(s.substring(index, i + 1))){
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                backtracking(s, i + 2, pointnum + 1);
                s = s.substring(0, i + 1) + s.substring(i + 2);
            }
        }
    }

    private boolean isValid(String s){
        if (s.length() == 0){
            return false;
        }
        if (s.charAt(0) == '0' && s.length() != 1){
            return false;
        }
        int num = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) > '9' || s.charAt(i) < '0'){
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255){
                return false;
            }
        }
        return true;
    }
}
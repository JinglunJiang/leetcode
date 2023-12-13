class Solution {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0, 0);
        return result;
    }

    public void backtracking(String s, int index, int pointnumber){
        if (pointnumber == 3){
            if (isValid(s, index, s.length() - 1)){
                result.add(s);
            }
            return;
        }

        for (int i = index; i < s.length(); i++){
            if (isValid(s, index, i)){
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointnumber++;
                backtracking(s, i + 2, pointnumber);
                s = s.substring(0, i + 1) + s.substring(i + 2);
                pointnumber--;
            }
            else{
                break;
            }
        }
    }

    public boolean isValid(String s, int startindex, int endindex){
        if (startindex > endindex){
            return false;
        }
        if (startindex != endindex && s.charAt(startindex) == '0'){
            return false;
        }
        int num = 0;
        for (int i = startindex; i <= endindex; i++){
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
class Solution {
    public boolean splitString(String s) {
        for (int i = 0; i < s.length(); i++){
            if (backtracking(s, i + 1, calculateValue(s.substring(0, i + 1)))){
                return true;
            }
        }
        return false;
    }

    public boolean backtracking(String s, int index, long currentValue){
        if (currentValue - calculateValue(s.substring(index)) == 1 && index != s.length()){
            return true;
        }
        for (int i = index; i < s.length(); i++){
            if (currentValue - calculateValue(s.substring(index, i + 1)) == 1){
                if (backtracking(s, i + 1, calculateValue(s.substring(index, i + 1)))){
                    return true;
                }
            }
        }
        return false;
    }

    public long calculateValue(String s){
        long count = 0;
        for(int i = 0; i < s.length(); i++){
            count = count * 10 + s.charAt(i) - '0';
        }
        return count;
    }
}
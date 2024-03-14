class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int matchstick : matchsticks){
            sum += matchstick;
        }
        if (sum % 4 != 0){
            return false;
        }
        int length = sum / 4;
        boolean[] used = new boolean[matchsticks.length];
        return backtracking(matchsticks, 0, 0, length, 0, used);
    }

    public boolean backtracking(int[] matchsticks, int index, int current, int target, int count, boolean[] used){
        if (count == 4){
            return true;
        }
        if (current == target){
            return backtracking(matchsticks, 0, 0, target, count + 1, used);
        }
        for (int i = index; i < matchsticks.length; i++){
            if (!used[i] && current + matchsticks[i] <= target){
                used[i] = true;
                if (backtracking(matchsticks, i + 1, current + matchsticks[i], target, count, used)){
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }
}
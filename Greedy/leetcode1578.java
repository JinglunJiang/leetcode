class Solution {
    public int minCost(String colors, int[] neededTime) {
        if (colors.length() <= 1){
            return 0;
        }
        int sum = 0;
        int max = neededTime[0];
        for (int i = 1; i < colors.length(); i++){
            if (colors.charAt(i) == colors.charAt(i - 1)){
                if (neededTime[i] < max){
                    sum += neededTime[i];
                }
                else{
                    sum += max;
                    max = neededTime[i];
                }
            }
            else{
                max = neededTime[i];
            }
        }
        return sum;
    }
}
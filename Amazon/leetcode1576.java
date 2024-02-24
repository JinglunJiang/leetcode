class Solution {
    public int getMaxLen(int[] nums) {
        int maxLength = 0;
        int positive = 0;
        int negative = 0;
        
        for (int num : nums){
            if (num == 0){
                positive = 0;
                negative = 0;
            }
            else if (num > 0){
                positive += 1;
                negative = negative > 0 ? negative + 1 : 0;
            }
            else{
                int temp = positive;
                positive = negative > 0 ? negative + 1 : 0;
                negative = temp + 1;
            }
            maxLength = Math.max(maxLength, positive);
        }
        return maxLength;
    }
}
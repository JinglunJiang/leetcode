class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1)
        return nums.length;
        int count = 1;
        int preDiff = 0;
        int curDiff = 0;
        for (int i = 1; i < nums.length; i++){
            curDiff = nums[i] - nums[i - 1];
            if (preDiff <= 0 && curDiff > 0){
                count++;
                preDiff = curDiff;
            }
            else if (preDiff >= 0 && curDiff < 0){
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }
}
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        //Situation 1: the maximum from 0 to nums.length - 2
        int[] dp1 = new int[nums.length - 1];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length - 1; i++){
            dp1[i] = Math.max(nums[i] + dp1[i - 2], dp1[i - 1]);
        }
        //Situation 2: the maximum from 1 to nums.length - 1
        int[] dp2 = new int[nums.length - 1];
        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1], nums[2]);
        for (int i = 2; i < nums.length - 1; i++){
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i + 1]);
        }
        return Math.max(dp1[nums.length - 2], dp2[nums.length - 2]);
    }
}
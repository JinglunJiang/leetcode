class Solution {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        for (int i = 0; i <= max; i++){
            max = Math.max(i + nums[i], max);
            if (max >= nums.length - 1){
                return true;
            }
        }
        return false;
    }
}
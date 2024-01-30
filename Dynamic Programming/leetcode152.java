class Solution {
    public int maxProduct(int[] nums) {
        int[] maxdp = new int[nums.length];
        int[] mindp = new int[nums.length];

        maxdp[0] = nums[0];
        mindp[0] = nums[0];

        int result = maxdp[0];

        for (int i = 1; i < nums.length; i++){
            maxdp[i] = Math.max(nums[i], Math.max(maxdp[i - 1] * nums[i], mindp[i - 1] * nums[i]));
            mindp[i] = Math.min(nums[i], Math.min(mindp[i - 1] * nums[i], maxdp[i - 1] * nums[i]));
            result = Math.max(maxdp[i], result);
        }
        return result;
    }
}
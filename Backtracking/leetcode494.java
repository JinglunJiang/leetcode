class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        backtracking(nums, target, 0, 0);
        return count;
    }

    public void backtracking(int[] nums, int target, int index, int sum){
        if (index == nums.length){
            if (sum == target){
                count++;
            }
            return;
        }
        backtracking(nums, target, index + 1, sum + nums[index]);
        backtracking(nums, target, index + 1, sum - nums[index]);
        return;
    }
}
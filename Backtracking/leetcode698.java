class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if (sum % k != 0){
            return false;
        }
        int target = sum / k;
        boolean[] visited = new boolean[nums.length];
        return backtracking(nums, target, k, 0, 0, 0, visited);
    }

    public boolean backtracking(int[] nums, int target, int k, int count, int currentSum, int index, boolean[] visited){
        if (count == k){
            return true;
        }
        if (currentSum == target){
            return backtracking(nums, target, k, count + 1, 0, 0, visited);
        }
        for (int i = index; i < nums.length; i++){
            if (nums[i] + currentSum <= target && !visited[i]){
                visited[i] = true;
                if (backtracking(nums, target, k, count, currentSum + nums[i], i + 1, visited)){
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
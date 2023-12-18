class Solution {
    int count = 0;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if (sum % k != 0){
            return false;
        }
        int target = sum / k;
        boolean[] visited = new boolean[nums.length];
        return backtracking(0, nums, target, k, visited, 0);
    }

    public boolean backtracking(int start, int[] nums, int target, int k, boolean[] visited, int sum){
        if (k == 0){
            return true;
        }
        if (sum == target){
            return backtracking(0, nums, target, k - 1, visited, 0);
        }
        for (int i = start; i < nums.length; i++){
            if (!visited[i] && sum + nums[i] <= target){
                visited[i] = true;
                if (backtracking(i + 1, nums, target, k, visited, sum + nums[i])){
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
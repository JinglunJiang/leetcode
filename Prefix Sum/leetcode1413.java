class Solution {
    public int minStartValue(int[] nums) {
        int[] prefixSum = new int[nums.length];
        int min = nums[0];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i];
            min = Math.min(prefixSum[i], min);
        }
        if (min > 0){
            return 1;
        }
        return 1 - min;
    }
}
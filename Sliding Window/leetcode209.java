class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++){
            sum += nums[j];
            while (sum >= target){
                result = Math.min(result, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }
        if (result == Integer.MAX_VALUE){
            return 0;
        }
        return result;
    }
}
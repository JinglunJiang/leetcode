class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int result = 0;
        for (int num : nums){
            result += num;
            max = Math.max(max, result);
            if (result < 0){
                result = 0;
            }
        }
        return max;
    }
}
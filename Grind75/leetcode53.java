class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int current = 0;
        for (int num : nums){
            current += num;
            max = Math.max(max, current);
            if (current < 0){
                current = 0;
            }
        }
        return max;
    }
}
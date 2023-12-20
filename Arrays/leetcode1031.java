class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++){
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int result = 0;
        int left = 0;
        int right = 0;
        for (int i = firstLen; i <= nums.length - secondLen; i++){
            left = Math.max(sum[i] - sum[i - firstLen], left);
            result = Math.max(sum[i + secondLen] - sum[i] + left, result);
        }
        for (int i = secondLen; i <= nums.length - firstLen; i++){
            right = Math.max(sum[i] - sum[i - secondLen], right);
            result = Math.max(sum[i + firstLen] - sum[i] + right, result);
        }
        return result;
    }
}
class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        long sum = 0;
        int result = 1;
        for (int j = 0; j < nums.length; j++){
            sum += nums[j];
            if ((long) nums[j] * (j - i + 1) - sum <= k){
                result = Math.max(j - i + 1, result);
            }
            else{
                sum -= nums[i];
                i++;
            }
        }
        return result;
    }
}
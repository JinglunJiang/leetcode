class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        int end = 0;
        int temp = 0;
        int result = 0;
        for (int i = 0; i <= end && i < nums.length; i++){
            temp = Math.max(temp, i + nums[i]);
            if (temp >= nums.length - 1){
                result++;
                return result;
            }
            if (i == end){
                result++;
                end = temp;
            }
        }
        return result;
    }
}
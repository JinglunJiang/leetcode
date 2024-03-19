class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int[] result = new int[nums.length];
        int current = result.length - 1;
        while (i <= j){
            if (Math.abs(nums[i]) > Math.abs(nums[j])){
                result[current] = nums[i] * nums[i];
                i++;
            }
            else{
                result[current] = nums[j] * nums[j];
                j--;
            }
            current--;
        }
        return result;
    }
}
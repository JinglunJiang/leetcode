class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int max = 0;
        int count = 0;
        for (int j = 0; j < nums.length; j++){
            if (nums[j] == 1){
                count++;
            }
            if (j - i + 1 <= k + count){
                max = Math.max(max, j - i + 1);
            }
            else{
                while (nums[i] != 0){
                    i++;
                    count--;
                }
                i++;
            }
        }
        return max;
    }
}
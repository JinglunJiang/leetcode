class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int count = 0;
        int notone = 0;
        int i = 0;
        int j = 0;
        while (j < nums.length){
            if (nums[j] != 1){
                notone++;
                while (notone > 1){
                    if (nums[i] == 1){
                        i++;
                        count--;
                    }
                    else{
                        notone--;
                        i++;
                    }
                }
            }
            else{
                count++;
                max = Math.max(count, max);
            }
            j++;
        }
        if (notone == 0){
            max = max - 1;
        }
        return max;
    }
}
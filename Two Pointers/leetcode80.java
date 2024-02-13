class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < nums.length){
            if (j == 0 || nums[j] == nums[j - 1]){
                count++;
            }
            else{
                count = 1;
            }
            if (count <= 2){
                nums[i] = nums[j];
                i++;
            }
            else{
                while (j + 1 < nums.length && nums[j + 1] == nums[j]){
                    j++;
                }
            }
            j++;
        }
        return i;
    }
}
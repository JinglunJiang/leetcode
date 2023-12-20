class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int count = 0;
        while (j > i){
            if (nums[i] + nums[j] < k){
                i++;
            }
            else if (nums[i] + nums[j] > k){
                j--;
            }
            else if (nums[i] + nums[j] == k){
                count++;
                i++;
                j--;
            }
        }
        return count;
    }
}
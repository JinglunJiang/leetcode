class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums[nums.length - 1] - nums[0];
        while (i < j){
            int mid = i + (j - i) / 2;
            if (countPair(nums, mid) >= p){
                j = mid;
            }
            else{
                i = mid + 1;
            }
        }
        return i;
    }

    public int countPair(int[] nums, int maxDiff){
        int count = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] - nums[i - 1] <= maxDiff){
                count++;
                i++;
            }
        }
        return count;
    }
}
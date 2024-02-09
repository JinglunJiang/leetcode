class Solution {
    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i] + k)){
                count += map.get(nums[i] + k);
            }
        }
        return count;
    }
}
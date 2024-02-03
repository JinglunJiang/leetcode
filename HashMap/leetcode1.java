class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            if (map.containsKey(target - num) && map.get(target - num) != i){
                result[0] = i;
                result[1] = map.get(target - num);
                return result;
            }
            map.put(num, i);
        }
        return result;
    }
}
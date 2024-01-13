class Solution {
    public int longestConsecutive(int[] nums) {
        //No sorting algorithm should ever be used since its O(nlogn)
        if (nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        int count = 1;
        int result = 1;
        for (int num : set){
            if (!set.contains(num - 1)){
                while (set.contains(num + 1)){
                    count++;
                    num = num + 1;
                    result = Math.max(count, result);
                }
            }
            count = 1;
        }
        return result;
    }
}
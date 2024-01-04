class Solution {
    public int minOperations(int[] nums) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int num : map.keySet()){
            if (map.get(num) % 3 == 0){
                sum += map.get(num) / 3;
            }
            else{
                int count = map.get(num);
                while (count != 0){
                    if (count == 1){
                        return -1;
                    }
                    count -= 2;
                    sum += 1;
                    if (count % 3 == 0){
                        sum += count / 3;
                        break;
                    }
                }
            }
        }
        return sum;
    }
}
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++){
            int sum = 0;
            for (int num : nums){
                sum += (num >> i) & 1;
            }
            result |= (sum % 3) << i;
        }
        return result;
    }
}
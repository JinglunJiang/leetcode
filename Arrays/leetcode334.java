class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int num : nums){
            if (num <= first){
                first = num;
            }
            if (num > first && num <= second){
                second = num;
            }
            if (num > first && num > second){
                return true;
            }
        }
        return false;
    }
}
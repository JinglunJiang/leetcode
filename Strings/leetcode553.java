class Solution {
    public String optimalDivision(int[] nums) {
        String result = "";
        if (nums.length == 1){
            return result + nums[0];
        }
        if (nums.length == 2){
            return result + nums[0] + '/' + nums[1];
        }
        for (int i = 0; i < nums.length; i++){
            if (i == 0){
                result += nums[i];
                result += '/';
                result += '(';
            }
            else if (i == (nums.length - 1)){
                result += nums[i];
            }
            else{
                result += nums[i];
                result += '/';
            }
        }
        result += ')';
        return result;
    }
}
class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++){
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        StringBuilder sb = new StringBuilder();
        for (String str : arr){
            sb.append(str);
        }
        if (sb.charAt(0) == '0'){
            return "0";
        }
        return sb.toString();
    }
}
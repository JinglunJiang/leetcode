class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int result = 0;
        while (i < j){
            int currHeight = Math.min(height[i], height[j]);
            result = Math.max(currHeight * (j - i), result);
            if (height[i] < height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return result;
    }
}
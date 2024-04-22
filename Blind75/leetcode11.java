class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j){
            int width = j - i;
            int result = Math.min(height[i], height[j]) * width;
            max = Math.max(result, max);
            if (height[i] < height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return max;
    }
}
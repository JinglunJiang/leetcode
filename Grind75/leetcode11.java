class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j){
            if (height[i] < height[j]){
                max = Math.max(height[i] * (j - i), max);
                i++;
            }
            else{
                max = Math.max(max, height[j] * (j - i));
                j--;
            }
        }
        return max;
    }
}
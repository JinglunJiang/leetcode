class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];
        int result = 0;
        for (int i = 1; i < height.length; i++){
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        for (int j = height.length - 2; j >= 0; j--){
            rightMax[j] = Math.max(height[j], rightMax[j + 1]);
        }
        for (int i = 0; i < height.length; i++){
            if (Math.min(leftMax[i], rightMax[i]) - height[i] > 0){
                result += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
        }
        return result;
    }
}
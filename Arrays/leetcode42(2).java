class Solution {
    public int trap(int[] height) {
        if (height.length <= 2){
            return 0;
        }
        int sum = 0;
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++){
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int j = height.length - 2; j >= 0; j--){
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }
        for (int i = 0; i < height.length; i++){
            int minValue = Math.min(leftMax[i], rightMax[i]);
            if (minValue - height[i] > 0){
                sum += minValue - height[i];
            }
        }
        return sum;
    }
}
class Solution {
    public int trap(int[] height) {
        int[] maxleft = new int[height.length];
        int[] maxright = new int[height.length];
        maxleft[0] = height[0];
        maxright[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++){
            maxleft[i] = Math.max(maxleft[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--){
            maxright[i] = Math.max(maxright[i + 1], height[i + 1]);
        }
        int result = 0;
        for (int i = 0; i < height.length; i++){
            if (Math.min(maxleft[i], maxright[i]) - height[i] > 0){
                result += Math.min(maxleft[i], maxright[i]) - height[i];
            }
        }
        return result;
    }
}
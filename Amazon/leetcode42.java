class Solution {
    public int trap(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int result = 0;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        while (i < j){
            if (leftMax < rightMax){
                i++;
                if (height[i] < leftMax){
                    result += leftMax - height[i];
                }
                else{
                    leftMax = height[i];
                }
            }
            else{
                j--;
                if (height[j] < rightMax){
                    result += rightMax - height[j];
                }
                else{
                    rightMax = height[j];
                }
            }
        }
        return result;
    }
}
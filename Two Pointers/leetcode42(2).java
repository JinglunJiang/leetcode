class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int sum = 0;
        while (left < right){
            if (leftMax < rightMax){
                left++;
                if (height[left] > leftMax){
                    leftMax = height[left];
                }
                else{
                    sum += leftMax - height[left];
                }
            }
            else{
                right--;
                if (rightMax < height[right]){
                    rightMax = height[right];
                }
                else{
                    sum += rightMax - height[right];
                }
            }
        }
        return sum;
    }
}
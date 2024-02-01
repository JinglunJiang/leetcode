class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxRight = height[height.length - 1];
        int maxLeft = height[0];
        int sum = 0;
        while (left < right){
            if (maxLeft < maxRight){
                left++;
                if (height[left] > maxLeft){
                    maxLeft = height[left];
                }
                else{
                    sum += maxLeft - height[left];
                }
            }
            else{
                right--;
                if (height[right] > maxRight){
                    maxRight = height[right];
                }
                else{
                    sum += maxRight - height[right];
                }
            }
        }
        return sum;
    }
}
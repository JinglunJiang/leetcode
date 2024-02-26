class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++){
            if (stack.isEmpty()){
                stack.push(i);
            }
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                map.put(nums2[stack.pop()], nums2[i]);
            }
            if (stack.isEmpty() || nums2[i] <= nums2[stack.peek()]){
                stack.push(i);
            }
        }
        for (int i = 0; i < nums1.length; i++){
            if (map.containsKey(nums1[i])){
                result[i] = map.get(nums1[i]);
            }
            else{
                result[i] = -1;
            }
        }
        return result;
    }
}
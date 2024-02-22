class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++){
            if (stack.isEmpty() || temperatures[stack.peek()] >= temperatures[i]){
                stack.push(i);
            }
            else{
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                    result[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return result;
    }
}
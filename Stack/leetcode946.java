class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        for (int item : pushed){
            stack.push(item);
            while (!stack.isEmpty() && stack.peek() == popped[i]){
                stack.pop();
                i++;
            }
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }
}
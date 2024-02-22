class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens){
            if (Character.isDigit(token.charAt(0)) || token.charAt(0) == '-' && token.length() != 1){
                stack.push(Integer.parseInt(token));
            }
            else if (token.equals("+")){
                int first = stack.pop();
                int second = stack.pop();
                stack.push(first + second);
            }
            else if (token.equals("-")){
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first - second);
            }
            else if (token.equals("*")){
                int first = stack.pop();
                int second = stack.pop();
                stack.push(first * second);
            }
            else if (token.equals("/")){
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first / second);
            }
        }
        return stack.peek();
    }
}
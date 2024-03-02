class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens){
            if ((token.charAt(0) == '-' && token.length() != 1) || Character.isDigit(token.charAt(0))){
                stack.push(Integer.parseInt(token));
            }
            else{
                int a = stack.pop();
                int b = stack.pop();
                if (token.equals("+")){
                    stack.push(a + b);
                }
                else if (token.equals("-")){
                    stack.push(b - a);
                }
                else if (token.equals("*")){
                    stack.push(a * b);
                }
                else{
                    stack.push(b / a);
                }
            }
        }
        return stack.peek();
    }
}
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            else if (c == ')'){
                if (stack.isEmpty() || stack.peek() != '('){
                    return false;
                }
                stack.pop();
            }
            else if (c == '}'){
                if (stack.isEmpty() ||stack.peek() != '{'){
                    return false;
                }
                stack.pop();
            }
            else{
                if (stack.isEmpty() || stack.peek() != '['){
                    return false;
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '#'){
                if (!stack1.isEmpty()){
                    stack1.pop();
                }
            }
            else{
                stack1.push(c);
            }
        }
        Stack<Character> stack2 = new Stack<>();
        for (char c : t.toCharArray()){
            if (c == '#'){
                if (!stack2.isEmpty()){
                    stack2.pop();
                }
            }
            else{
                stack2.push(c);
            }
        }
        if (stack1.size() != stack2.size()){
            return false;
        }
        while (!stack1.isEmpty()){
            if (stack1.pop() != stack2.pop()){
                return false;
            }
        }
        return true;
    }
}
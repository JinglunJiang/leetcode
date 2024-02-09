class Solution {
    public String reverseParentheses(String s) {
        int[] index = new int[s.length()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            }
            else if (s.charAt(i) == ')'){
                int ind = stack.pop();
                index[i] = ind;
                index[ind] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        
        int d = 1;
        for (int i = 0; i < s.length(); i += d){
            if (s.charAt(i) == '(' || s.charAt(i) == ')'){
                i = index[i];
                d = -d;
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
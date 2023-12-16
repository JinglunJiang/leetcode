class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        visited.add(s);
        boolean found = false;

        while (!queue.isEmpty()){
            String current = queue.poll();
            if (isValid(current)){
                result.add(current);
                found = true;
            }
            if (found){
                continue;
            }
            for (int i = 0; i < current.length(); i++){
                if (current.charAt(i) != '(' && current.charAt(i) != ')'){
                    continue;
                }
                String nextstr = current.substring(0, i) + current.substring(i + 1);
                if (!visited.contains(nextstr)){
                    queue.offer(nextstr);
                    visited.add(nextstr);
                }
            }
        }
        return result;
    }

    private boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c != '(' && c != ')'){
                continue;
            }
            else if (c == '('){
                stack.push(c);
            }
            else if (c == ')'){
                if (!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
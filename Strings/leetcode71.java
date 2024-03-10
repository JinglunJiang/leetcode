class Solution {
    public String simplifyPath(String path) {
        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String component : components){
            if (component.equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }
            else if (!component.equals(".") && !component.equals("")){
                stack.push(component);
            }
        }
        StringBuilder sb = new StringBuilder();
        int n = stack.size();
        for (int i = 0; i < n; i++){
            if (i == 0){
                sb.append(stack.pop());
            }
            else{
                sb.insert(0, stack.pop() + '/');
            }
        }
        sb.insert(0, '/');
        return sb.toString();
    }
}
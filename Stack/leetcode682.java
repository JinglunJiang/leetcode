class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String operation : operations){
            if (operation.charAt(0) == '-'){
                stack.push(Integer.parseInt(operation));
            }
            if (isNumeric(operation)){
                stack.push(Integer.parseInt(operation));
            }
            else if (operation.charAt(0) == '+'){
                int second = stack.pop();
                int first = stack.peek();
                stack.push(second);
                stack.push(first + second);
            }
            else if (operation.charAt(0) == 'D'){
                stack.push(stack.peek() * 2);
            }
            else if (operation.charAt(0) == 'C'){
                stack.pop();
            }
        }
        int sum = 0;
        while (!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }

    public boolean isNumeric(String str){
        for (char c : str.toCharArray()){
            if (!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public String decodeString(String s) {
        StringBuilder str = new StringBuilder();
        Stack<StringBuilder> strBuild = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int num = 0;
        for (char c : s.toCharArray()){
            if (c >= '0' && c <= '9'){
                num = 10 * num + c - '0';
            }
            else if (c == '['){
                numStack.push(num);
                num = 0;
                strBuild.push(str);
                str = new StringBuilder();
            }
            else if (c == ']'){
                StringBuilder temp = str;
                int count = numStack.pop();
                str = strBuild.pop();
                while (count-- > 0){
                    str.append(temp);
                }
            }
            else{
                str.append(c);
            }
        }
        return str.toString();
    }
}
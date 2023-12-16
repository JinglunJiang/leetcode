class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n == 0){
            return result;
        }
        backtracking(n, new StringBuilder(), 0);
        return result;
    }

    private void backtracking(int n, StringBuilder str, int count){
        if (str.length() == n * 2){
            if (count == 0){
                String string = str.toString();
                result.add(string);
            }
            return;
        }
        if (count > 0){
            str.append(')');
            backtracking(n, str, count - 1);
            str.deleteCharAt(str.length() - 1);
        }
        str.append('(');
        backtracking(n, str, count + 1);
        str.deleteCharAt(str.length() - 1);
    }
}
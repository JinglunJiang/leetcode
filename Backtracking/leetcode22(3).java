class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        backtracking(sb, 0, 0, n);
        return result;
    }

    public void backtracking(StringBuilder sb, int open, int close, int n){
        if (open == close && open == n){
            String str = sb.toString();
            result.add(str);
            return;
        }
        if (open < n){
            sb.append('(');
            backtracking(sb, open + 1, close, n);
            sb.delete(sb.length() - 1, sb.length());
        }
        if (close < open){
            sb.append(')');
            backtracking(sb, open, close + 1, n);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}
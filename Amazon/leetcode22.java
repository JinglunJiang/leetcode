class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        generate(n, 0, 0, sb);
        return result;
    }

    public void generate(int n, int open, int close, StringBuilder sb){
        if (open == close && open == n){
            String str = sb.toString();
            result.add(str);
            return;
        }
        if (open < n){
            sb.append('(');
            generate(n, open + 1, close, sb);
            sb.delete(sb.length() - 1, sb.length());
        }
        if (close < open){
            sb.append(')');
            generate(n, open, close + 1, sb);
            sb.delete(sb.length() - 1, sb.length());
        }
        return;
    }
}
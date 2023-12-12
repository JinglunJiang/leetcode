class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard){
            Arrays.fill(c, '.');
        }
        backtracking(n, 0, chessboard);
        return result;
    }

    public void backtracking(int n, int row, char[][] chessboard){
        if (row == n){
            result.add(ArraytoString(chessboard));
            return;
        }
        for (int col = 0; col < n; col++){
            if (isValid(n, row, col, chessboard)){
                chessboard[row][col] = 'Q';
                backtracking(n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    public List<String> ArraytoString(char[][] chessboard){
        List<String> list = new ArrayList<>();
        for (char[] c : chessboard){
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    public boolean isValid(int n, int row, int col, char[][] chessboard){
        for (int i = 0; i < row; i++){
            if (chessboard[i][col] == 'Q'){
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if (chessboard[i][j] == 'Q'){
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++){
            if (chessboard[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
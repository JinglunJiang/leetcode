class Solution {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if ((i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) && board[i][j] == 'O'){
                    board[i][j] = '*';
                    dfs(board, i , j);
                }
            }
        }
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if (board[i][j] == '*'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j){
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int[] direction : directions){
            int row = i + direction[0];
            int column = j + direction[1];
            if (row >= 0 && column >= 0 && row < board.length && column < board[0].length && board[row][column] == 'O'){
                board[row][column] = '*';
                dfs(board, row, column);
            }
        }
    }
}
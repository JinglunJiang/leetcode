class Solution {
    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    public boolean backtracking(char[][] board){ // returns boolean (only one answer)
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] == '.'){
                    for (char k = '1'; k <= '9'; k++){
                        if (isValid(board, i, j, k)){
                            board[i][j] = k;
                            if (backtracking(board)){
                                return true; // returns boolean
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false; // Tried all 9 numbers, none of them can fit, thus false
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int x, int y, int val){
        for (int i = 0; i < 9; i++){
            if (board[x][i] == val){
                return false;
            }
        }
        for (int i = 0; i < 9; i++){
            if (board[i][y] == val){
                return false;
            }
        }
        int xindex = x / 3;
        int yindex = y / 3;
        for (int i = xindex * 3; i < xindex * 3 + 3; i++){
            for (int j = yindex * 3; j < yindex * 3 + 3; j++){
                if (board[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }
}
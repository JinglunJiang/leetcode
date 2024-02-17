class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (rowValid(board) && columnValid(board) && gridValid(board)){
            return true;
        }
        return false;
    }

    private boolean rowValid(char[][] board){
        for (int i = 0; i < board.length; i++){
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] != '.'){
                    if (set.contains(board[i][j])){
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
        }
        return true;
    }

    private boolean columnValid(char[][] board){
        for (int j = 0; j < board[0].length; j++){
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < board.length; i++){
                if (board[i][j] != '.'){
                    if (set.contains(board[i][j])){
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
        }
        return true;
    }

    private boolean gridValid(char[][] board){
        for (int i = 0; i < board.length; i = i + 3){
            for (int j = 0; j < board[0].length; j = j + 3){
                HashSet<Character> set = new HashSet<>();
                for (int m = i; m < i + 3; m++){
                    for (int n = j; n < j + 3; n++){
                        if (board[m][n] != '.'){
                            if (set.contains(board[m][n])){
                                return false;
                            }
                        }
                        set.add(board[m][n]);
                    }
                }
            }
        }
        return true;
    }
}
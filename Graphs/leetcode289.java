class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
    public void gameOfLife(int[][] board) {
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                newBoard[i][j] = board[i][j];
            }
        }
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                int count = 0;
                for (int[] direction : directions){
                    int row = i + direction[0];
                    int column = j + direction[1];
                    if (row >= 0 && column >= 0 && row < board.length && column < board[0].length && newBoard[row][column] == 1){
                        count++;
                    }
                }
                if (newBoard[i][j] == 1){
                    if (count < 2){
                        board[i][j] = 0;
                    }
                    else if (count == 2 || count == 3){
                        board[i][j] = 1;
                    }
                    else {
                        board[i][j] = 0;
                    }
                }
                else{
                    if (count == 3){
                        board[i][j] = 1;
                    }
                }
            }
        }
    }
}
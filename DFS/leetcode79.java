class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (check(board, word, i, j, m, n, 0, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, String word, int row, int column, int m, int n, int index, boolean[][] visited){
        if (index == word.length()){
            return true;
        }
        if (row < 0 || row >= m || column < 0 || column >= n || visited[row][column] || word.charAt(index) != board[row][column]){
            return false;
        }
        visited[row][column] = true;
        if (check(board, word, row + 1, column, m, n, index + 1, visited) || check(board, word, row - 1, column, m, n, index + 1, visited) || check(board, word, row, column + 1, m, n, index + 1, visited) || check(board, word, row, column - 1, m, n, index + 1, visited)){
            return true;
        }
        visited[row][column] = false;
        return false;
    }
}
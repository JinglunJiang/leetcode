class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (dfs(board, i, j, word, 0, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] visited){
        if (index == word.length()){
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || word.charAt(index) != board[i][j]){
            return false;
        }
        visited[i][j] = true;
        for (int[] direction : directions){
            int row = direction[0] + i;
            int column = direction[1] + j;
            if (dfs(board, row, column, word, index + 1, visited)){
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}
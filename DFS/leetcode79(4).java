class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (dfs(i, j, 0, word, board, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, int index, String word, char[][] board, boolean[][] visited){
        if (index == word.length()){
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]){
            return false;
        }
        if (board[i][j] != word.charAt(index)){
            return false;
        }
        visited[i][j] = true;
        for (int[] direction : directions){
            int row = direction[0] + i;
            int column = direction[1] + j;
            if (dfs(row, column, index + 1, word, board, visited)){
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}
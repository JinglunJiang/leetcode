class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (dfs(board, i, j, 0, visited, word)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, int index, boolean[][] visited, String word){
        if (index == word.length()){
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }
        visited[i][j] = true;
        for (int[] direction : directions){
            int row = i + direction[0];
            int column = j + direction[1];
            if (dfs(board, row, column, index + 1, visited, word)){
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}
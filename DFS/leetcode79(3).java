class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                boolean[][] visited = new boolean[board.length][board[0].length];
                if (dfs(i, j, board, word, 0, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i , int j, char[][] board, String word, int index, boolean[][] visited){
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
            int row = i + direction[0];
            int column = j + direction[1];
            if (dfs(row, column, board, word, index + 1, visited)){
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if(dfs(board, i, j, word, visited, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private boolean dfs(char[][] board, int i, int j, String word, boolean[][] visited, int index){
        if (index == word.length()){
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || word.charAt(index) != board[i][j]){
            return false;
        }
        visited[i][j] = true;
        for (int[] direction : directions){
            int row = i + direction[0];
            int column = j + direction[1];
            if(dfs(board, row, column, word, visited, index + 1)){
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}
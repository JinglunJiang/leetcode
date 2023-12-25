class Solution {
    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++){
            if (grid[i][0] == 1){
                grid[i][0] = 0;
                dfs(grid, i, 0);
            }
            if (grid[i][column - 1] == 1){
                grid[i][column - 1] = 0;
                dfs(grid, i, column - 1);
            }
        }
        for (int j = 0; j < column; j++){
            if (grid[0][j] == 1){
                grid[0][j] = 0;
                dfs(grid, 0, j);
            }
            if (grid[row - 1][j] == 1){
                grid[row - 1][j] = 0;
                dfs(grid, row - 1, j);
            }
        }
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                if (grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int[][] grid, int i, int j){
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] direction : directions){
            int row = i + direction[0];
            int column = j + direction[1];
            if (row >= 0 && column >= 0 && row < grid.length && column < grid[0].length && grid[row][column] == 1){
                grid[row][column] = 0;
                dfs(grid, row, column);
            }
        }
    }
}
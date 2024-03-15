class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        for (int i = 0; i < grid2.length; i++){
            for (int j = 0; j < grid2[0].length; j++){
                if (grid2[i][j] == 1 && grid1[i][j] == 0){
                    setBlank(grid2, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < grid2.length; i++){
            for (int j = 0; j < grid2[0].length; j++){
                if (grid2[i][j] == 1){
                    count++;
                    dfs(grid2, i, j);
                }
            }
        }
        return count;
    }

    public void setBlank(int[][] grid, int i, int j){
        grid[i][j] = 0;
        for (int[] direction : directions){
            int row = i + direction[0];
            int column = j + direction[1];
            if (row >= 0 && column >= 0 && row < grid.length && column < grid[0].length && grid[row][column] == 1){
                setBlank(grid, row, column);
            }
        }
    }

    public void dfs(int[][] grid, int i, int j){
        grid[i][j] = 0;
        for (int[] direction : directions){
            int row = i + direction[0];
            int column = j + direction[1];
            if (row >= 0 && column >= 0 && row < grid.length && column < grid[0].length && grid[row][column] == 1){
                dfs(grid, row, column);
            }
        }
    }
}
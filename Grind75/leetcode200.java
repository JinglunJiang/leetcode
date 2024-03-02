class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private void dfs(char[][] grid, int i, int j){
        grid[i][j] = '0';
        for (int[] direction : directions){
            int row = i + direction[0];
            int column = j + direction[1];
            if (row >= 0 && row < grid.length && column >= 0 && column < grid[0].length && grid[row][column] == '1'){
                dfs(grid, row, column);
            }
        }
    }
}
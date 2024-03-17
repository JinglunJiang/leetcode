class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 0){
                    if (dfs(grid, i, j)){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean dfs(int[][] grid, int i, int j){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return false;
        }
        if (grid[i][j] == 1){
            return true;
        }
        grid[i][j] = 1;
        boolean isClosed = true;
        for (int[] direction : directions){
            int row = direction[0] + i;
            int column = direction[1] + j;
            isClosed &= dfs(grid, row, column);
        }
        return isClosed;
    }
}
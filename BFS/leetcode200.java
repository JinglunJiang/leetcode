class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    public void bfs(char[][] grid, int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            for (int[] direction : directions){
                int row = current[0] + direction[0];
                int column = current[1] + direction[1];
                if (row >= 0 && row < grid.length && column >= 0 && column < grid[0].length && grid[row][column] == '1'){
                    queue.offer(new int[]{row, column});
                    grid[row][column] = '0';
                }
            }
        }
    }
}
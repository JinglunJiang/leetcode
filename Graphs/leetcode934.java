class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    Queue<int[]> queue = new LinkedList<>();

    public int shortestBridge(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        boolean found = false;
        for (int i = 0; i < grid.length && !found; i++){
            for (int j = 0; j < grid[0].length && !found; j++){
                if (grid[i][j] == 1){
                    dfs(grid, i, j, visited);
                    found = true;
                }
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] current = queue.poll();
                for (int[] direction : directions){
                    int row = current[0] + direction[0];
                    int column = current[1] + direction[1];
                    if (row >= 0 && column >= 0 && row < grid.length && column < grid[0].length && !visited[row][column]){
                        if (grid[row][column] == 1){
                            return count;
                        }
                        visited[row][column] = true;
                        queue.offer(new int[]{row, column});
                    }
                }
            }
            count++;
        }
        return -1;
    }

    public void dfs(int[][] grid, int i, int j, boolean[][] visited){
        visited[i][j] = true;
        queue.offer(new int[]{i, j});
        for (int[] direction : directions){
            int row = i + direction[0];
            int column = j + direction[1];
            if (row >= 0 && column >= 0 && row < grid.length && column < grid[0].length && grid[row][column] == 1 && !visited[row][column]){
                dfs(grid, row, column, visited);
            }
        }
    }
}
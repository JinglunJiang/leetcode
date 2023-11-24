class Solution {
    public int shortestPath(int[][] grid, int k) {
        int[] start = new int[]{0, 0, k};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        boolean[][][] visited = new boolean[grid.length][grid[0].length][k + 1];
        visited[0][0][k] = true;
        int level = 0;
        if (grid[0][0] == 1){
            level++;
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] current = queue.poll();
                if (current[0] == grid.length - 1 && current[1] == grid[0].length - 1){
                    return level;
                }
                int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
                for (int[] direction: directions){
                    int row = current[0] + direction[0];
                    int column = current[1] + direction[1];
                    if (row >= 0 && row < grid.length && column >= 0 && column < grid[0].length) {
                        int remainingObstacles = current[2] - grid[row][column];

                        if (remainingObstacles >= 0 && !visited[row][column][remainingObstacles]) {
                            visited[row][column][remainingObstacles] = true;
                            queue.offer(new int[]{row, column, remainingObstacles});
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
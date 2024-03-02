class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1){
                    count++;
                }
            }
        }
        int time = 0;
        while (!queue.isEmpty() && count > 0){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] current = queue.poll();
                for (int[] direction : directions){
                    int row = current[0] + direction[0];
                    int column = current[1] + direction[1];
                    if (row >= 0 && row < grid.length && column >= 0 && column < grid[0].length && grid[row][column] == 1){
                        queue.offer(new int[]{row, column});
                        grid[row][column] = 2;
                        count--;
                    }
                }
            }
            time += 1;
        }
        if (count != 0){
            return -1;
        }
        return time;
    }
}
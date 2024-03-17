class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    queue.offer(new int[]{i, j});
                    count++;
                }
            }
        }
        if (count == 0 || count == grid.length * grid[0].length){
            return -1;
        }
        count = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] current = queue.poll();
                for (int[] direction : directions){
                    int row = current[0] + direction[0];
                    int column = current[1] + direction[1];
                    if (row >= 0 && column >= 0 && row < grid.length && column < grid[0].length && grid[row][column] == 0){
                        grid[row][column] = 1;
                        queue.offer(new int[]{row, column});
                    }
                }
            }
            count++;
        }
        return count - 1;
    }
}
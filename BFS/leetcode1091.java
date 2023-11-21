//use int[][]directions to store the directions
//Set the visited cells to 1 so that it won't waste the complexity of a set

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int level = 0;

        int[][] directions = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int column = current[1];

                if (row == grid.length - 1 && column == grid.length - 1) {
                    return level + 1;
                }

                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newColumn = column + dir[1];

                    if (newRow >= 0 && newRow < grid.length && newColumn >= 0 && newColumn < grid[0].length &&
                            grid[newRow][newColumn] == 0) {
                        queue.offer(new int[]{newRow, newColumn});
                        grid[newRow][newColumn] = 1;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}